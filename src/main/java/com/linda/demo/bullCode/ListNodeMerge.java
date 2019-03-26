package com.linda.demo.bullCode;

public class ListNodeMerge {
    public ListNode Merge(ListNode list1,ListNode list2) {
//        Queue<ListNode> queue = new LinkedList<>();
//        while(list1.val<list2.val){
//            ((LinkedList<ListNode>) queue).push(list1);
//            list1=list1.next;
//        }
//        while(list1.val>=list2.val){
//            ((LinkedList<ListNode>) queue).push(list2);
//            list2=list2.next;
//        }
//        return ((LinkedList<ListNode>) queue).pop();
        ListNode res=null;
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if(list1.val<list2.val){
            res=list1;
            res.next=Merge(list1.next,list2);
        }
        else{
            res=list2;
            res.next=Merge(list1,list2.next);
        }
        return res;
    }
}
