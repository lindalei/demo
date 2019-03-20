package com.linda.demo.bullCode;


public class CheckArrayTreePostOrderTraverse {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0){
            return false;
        }
        return isBST(sequence, 0, sequence.length-1);

    }
    public static boolean isBST (int[] sequence, int start, int end){
        int i=start;
        int root = sequence[end];
        if(start >= end){
            return true;
        }
        while(sequence[i] < root){
           i++;
        }
        int j=i;
        for (; j < end; j++) {
            if(sequence[j]<root){
                return false;
            }

        }
        boolean left =true;
        boolean right = true;
        if(i>start){
            left= isBST(sequence, start, i-1);
        }
        if(j<end){
            right = isBST(sequence,i,end-1);

        }
        return left&right;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left= new TreeNode(7);
        int[] array={7,4,6,5};
        System.out.println(VerifySquenceOfBST(array));
    }
}
