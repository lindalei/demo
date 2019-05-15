package com.linda.demo.bullCode;


public class SubTree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return false;
        if (root1 == null && root2 != null) return false;
        boolean flag = false;
        if (root1.val == root2.val) {
            flag = isSub(root1, root2);
        }
        if (!flag) {
            flag = isSub(root1.left, root2);
            if (!flag) {
                flag = isSub(root1.right, root2);
            }
        }
        return flag;
    }

    public boolean isSub(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null & root2 != null) {
            return false;
        }
        if (root1.val == root2.val) {
            return isSub(root1.left, root2.left) && isSub(root1.right, root2.right);
        } else {
            return false;
        }
    }
}
