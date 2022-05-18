package com.leetcode.labuladong.Tree;

public class Solution_1373 {
    int max;
    public int maxSumBST(TreeNode root) {
        max = 0;
        int[] res = traverse(root);
        return max;
    }
    private int[] traverse(TreeNode root){
        if (root == null){
            int[] res = {1, Integer.MAX_VALUE, Integer.MIN_VALUE,0};//分别返回子树的：是否为平衡二叉树，最小值，最大值，子树和
            return res;
        }

        int[] res = new int[4];

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        if(left[0] * right[0] == 1){
            if (root.val > left[2] && root.val < right[1]){
                res[0] = 1;
                res[1] = Math.min(root.val, left[1]);
                res[2] = Math.max(root.val, right[2]);
                res[3] = root.val + left[3] + right[3];
                max = Math.max(max,res[3]);
            }
        }
        else res[0] = 0;
        return res;
    }
}
