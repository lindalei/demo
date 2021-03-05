package com.linda.demo.leetcode.list;

import com.linda.demo.bullCode.ListNode;

//删除列表中倒数第N个节点
public class RemoveNthFromEnd {
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    if (head.next == null && n == 1) {
      return null;
    }

    int m = getSize(head) - n;
    int i = 0;
    ListNode node = head;
    if (m >= 1) {
      while (i < m - 1) {
        node = node.next;
        i++;
      }
      node.next = node.next.next;
    } else if (m == 0) {
      head = head.next;
    }

    return head;
  }

  public static int getSize(ListNode node) {
    int size = 0;
    while (node != null) {
      size++;
      node = node.next;
    }
    return size;
  }

  public static void main(String[] args) {
    ListNode first = new ListNode(1);
    ListNode second = new ListNode(2);
    ListNode third = new ListNode(3);
    ListNode fourth = new ListNode(4);
    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = null;
    ListNode listNode = removeNthFromEnd(first, 2);
    System.out.println(listNode.val);
  }
}


