package com.leetcode.labuladong.Tree;

public class Solution_105 {
    //根据前序、中序遍历构造二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return builder(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    private TreeNode builder(int[] preorder, int pl, int pr, int[] inorder, int il, int ir){
        //递归终止条件
        if(pl > pr || il > ir) return null;

//        执行主体
        TreeNode root = new TreeNode(preorder[pl]);
        int station = findInInorder(preorder[pl], inorder, il, ir);
        int lenOfLeft = station - il;
        int lenOfRight = ir - station;

//        左右子树递归
        root.left = builder(preorder, pl+1, pl + lenOfLeft, inorder, il, station-1);
        root.right = builder(preorder, pr - lenOfRight + 1, pr, inorder , station+1, ir);

        return root;
    }
    private int findInInorder(int target, int[] inorder, int il, int ir){
        int res = -1;

        for (int i = il; i <= ir; i++) {
            if(inorder[i] == target){
                res = i;
                break;
            }
        }
        return res;
    }
}
