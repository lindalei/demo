package com.linda.demo.bullCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintListFromTailToHead {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
//        while(!stack.isEmpty()) {
//            list.add(stack.pop());
//        }
        int j=stack.size();
        for (int i = 0; i < j ; i++) {
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(4);
        node.next.next = new ListNode(5);
        System.out.println(printListFromTailToHead(node));
    }
}
