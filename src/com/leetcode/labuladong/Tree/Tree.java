package com.leetcode.labuladong.Tree;

public class Tree {
    public boolean iffind = false;
    public TreeNode res = null;
    public TreeNode find(TreeNode root,TreeNode target1,TreeNode target2){
        method(root, target1, target2);
        return res;
    }
    public void method(TreeNode root,TreeNode target1,TreeNode target2){
        if (iffind) return;
        if (root == null) return;

        method(root.right, target1, target2);
        method(root.left, target1, target2);

        if(ifInThis(root, target1, target2)&&ifInThis(root, target1, target2)){
            iffind = true;
        }

    }
    public boolean ifInThis(TreeNode root,TreeNode target1,TreeNode target2){
        if (root == null) return false;

        if (root.left == target1 || root.right == target2) return  true;
        else {
            return ifInThis(root.left,target1,target2) || ifInThis(root.right,target1,target2);
        }
    }
}
