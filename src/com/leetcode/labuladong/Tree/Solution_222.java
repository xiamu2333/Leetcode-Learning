package com.leetcode.labuladong.Tree;

public class Solution_222 {
    public int countNodes(TreeNode root) {
        TreeNode left = root,right = root;
        int high_left = 0, high_right = 0;
        while (left != null){
            left = left.left;
            high_left++;
        }
        while (right != null){
            right = right.right;
            high_right++;
        }
        if (high_left == high_right){
            return (int) (Math.pow(2,high_left)-1);
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
