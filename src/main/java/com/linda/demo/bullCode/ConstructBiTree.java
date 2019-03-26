package com.linda.demo.bullCode;

public class ConstructBiTree {
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConstructBinaryTreeHandle(pre,0,pre.length-1,in,0,in.length-1);
    }
    public static TreeNode reConstructBinaryTreeHandle(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        for (int i = inStart; i <= inEnd ; i++) {
            if(in[i] == root.val){
                root.left=reConstructBinaryTreeHandle(pre,preStart+1,preStart+i-inStart,in,inStart,i-1);
                root.right=reConstructBinaryTreeHandle(pre,preStart+i-inStart+1, preEnd, in, i+1,inEnd);
               break;
            }
        }
        return root;
    }

    public static void main(String[] args){
         int[] pre={1,2,4,7,3,5,6,8};
         int[] in={4,7,2,1,5,3,8,6};
        System.out.println(reConstructBinaryTree(pre,in));
    }
}
