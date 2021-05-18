package com.linda.demo.leetcode.list;

import com.linda.demo.bullCode.ListNode;

public class RotateRight {
  public ListNode rotateRight(ListNode head, int k) {
    //基本情况
    if (head == null) return null;
    if (head.next == null) return head;
    //形成环
    ListNode oldTail = head;
    int n;
    for (n = 1; oldTail.next != null; n++) {
      oldTail = oldTail.next;
    }
    oldTail.next = head;
    //确认新的尾部和头部
    ListNode newTail = head;
    ListNode newHead;
    for (int i = 0; i < n - k - 1; i++) {
      newTail = newTail.next;
    }
    newHead = newTail.next;
    //断开原来的尾部
    newTail.next = null;
    return newHead;
  }
}
