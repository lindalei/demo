package com.linda.demo.bullCode;

import java.util.Stack;

public class FindKthToTail {
    public static ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k==0){
            return null;
        }
        ListNode p = head;
        int len =0;
        while(p!=null){
            len++;
            p=p.next;
        }
        if(len<k){
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        int i=0;
        while(i<=len-k){
            stack.push(head);
            head=head.next;
            i++;
        }
        return stack.pop();
    }

}
