package com.linda.demo.leetcode.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
BFS, 队列，先进先出
 */
public class WordLadder {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Queue<String> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    queue.offer(beginWord);
    int count = 1;
    while (!queue.isEmpty()) {
      String original = queue.poll();
      char[] originalChar = original.toCharArray();
      for (int i = 0; i < originalChar.length; i++) {
        char c = originalChar[i];
        for (char k = 'a'; k <= 'z'; k++) {
          if (k == c) {
            continue;
          }
          originalChar[i] = k;
          String newString = String.valueOf(originalChar);
          if (wordList.contains(newString)) {
            if (newString.equals(endWord)) {
              return count++;
            }
            if (!visited.contains(newString)) {
              queue.add(newString);
              visited.add(newString);
            }
          }
        }
        originalChar[i] = c;
      }
      count++;
    }
    return 0;
  }

  public static void main(String[] args) {
    WordLadder wordLadder = new WordLadder();
    ArrayList<String> strings = new ArrayList<>();
    Collections.addAll(strings, "hot", "dot", "dog", "lot", "log", "cog");
    System.out.println(wordLadder.ladderLength("hit", "cog", strings));
  }
}
