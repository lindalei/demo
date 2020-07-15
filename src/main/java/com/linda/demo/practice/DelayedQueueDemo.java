package com.linda.demo.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedQueueDemo {
  // 存储爱企业某一电影各个页面的过期时间
  DelayQueue<CacheInvalid> delayQueue = new DelayQueue<>();

  public static void main(String[] args) {
    DelayedQueueDemo demo= new DelayedQueueDemo();
    demo.setMovieInfo();
  }

  public void setMovieInfo() {
    MovieCache movieCache = new MovieCache();
    //存储电影各页面名字，页面内容和页面过期时间
    movieCache.setMovieCache("movieIntroduction", "a sad love story", 5);
    movieCache.setMovieCache("director", "Hou xiao xian", 2);
    movieCache.setMovieCache("actor", "shu qi, zhan zhen", 3);

    boolean expired = false;
    while (!expired) {
      //不为null, 说明dealyQueue中的页面条目已到了一定时间
      CacheInvalid cacheInvalid = delayQueue.poll();
      if (cacheInvalid != null) {
        //到期后，将缓存map中的页面条目删除
       movieCache.getMovieCache().remove(cacheInvalid.getKey());
        System.out.println(
            cacheInvalid.getKey() + " 完成学业用了 " + cacheInvalid.getExpireTime()
                + " seconds");
      } if (movieCache.getMovieCache().isEmpty()) {
        expired = true;
      }
    }
  }

  private class MovieCache {
    Map<String, String> movieCache = new HashMap();

    public void setMovieCache(String key, String value, long expireTime) {
      // 构建页面过期项，存储页面名字和页面到期时间
      CacheInvalid cacheInvalid = new CacheInvalid(key, expireTime);
      //将页面过期项加入delayedQueue
      delayQueue.add(cacheInvalid);
      //将页面条目存储到缓存
      movieCache.put(key, value);
    }

    public Map<String, String> getMovieCache() {
      return movieCache;
    }
  }

  private class CacheInvalid implements Delayed {
    private String key;
    private long currentTime;
    private long expireTime;

    public CacheInvalid(String key, long expireTime) {
      this.key = key;
      this.currentTime = System.currentTimeMillis();
      this.expireTime = expireTime;
    }

    public String getKey() {
      return this.key;
    }

    public long getExpireTime() {
      return expireTime;
    }

    //大于0说明还没过期，小于等于0说明到期
    @Override
    public long getDelay(TimeUnit unit) {
      return expireTime - TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - currentTime);
    }

    @Override
    public int compareTo(Delayed o) {
      if (this.getDelay(TimeUnit.MICROSECONDS) > o.getDelay(TimeUnit.MICROSECONDS)) {
        return 1;
      } else if (this.getDelay(TimeUnit.MICROSECONDS) < o.getDelay(TimeUnit.MICROSECONDS)) {
        return -1;
      }
      return 0;
    }
  }
}
