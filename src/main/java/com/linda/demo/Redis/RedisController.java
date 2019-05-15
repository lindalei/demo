package com.linda.demo.Redis;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
@Api(tags="redis test API")
public class RedisController {
    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("set/{key}/{value}")
    @ApiOperation("set cache")
    public String set(@PathVariable("key") String key, @PathVariable("value") String value){
       redisTemplate.opsForValue().set(key,value);
       return key+", "+value;
    }

    @GetMapping("get/{key}")
    @ApiOperation("get cache")
    public String get(@PathVariable("key") String key){
        return "key="+key+",value="+redisTemplate.opsForValue().get(key);
    }

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
}
