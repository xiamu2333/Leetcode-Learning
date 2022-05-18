package com.leetcode.labuladong.Tree;

public class Solution_654 {
    //给一个无序数组，将最大的一个作为根节点，这个数的前后两部分数组分别作为左右子树，递归构建
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return bulid(nums, 0, nums.length-1);
    }
    private TreeNode bulid(int[] nums, int l, int r){
        if(l > r) return null;

        int index = -1, max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) {
            if(max < nums[i]){
                max = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = bulid(nums, l , index-1);
        root.right = bulid(nums, index+1, r);
        return root;
    }
}
