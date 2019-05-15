package com.linda.demo.algocasts;

public class minLinkedList {
    int min = Integer.MAX_VALUE;
    Node head = null;

    class Node {
        private int val;
        private Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public void push(int x) {
        if (x < min) {
            head = new Node(min, head);
            min = x;
        }
        head = new Node(x, head);
    }

    public void pop() {
        if(head.val==min){
            min=head.next.val;
            head=head.next.next;
        }
        else{
          head=head.next;
        }
    }

    public int top(){
        return head.val;
    }

    public int getMin(){
        return min;
    }
}
