package com.leetcode.labuladong.Tree;

public class Solution_889 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return builder(preorder, 0, preorder.length-1,
                postorder, 0, postorder.length-1);
    }
    private TreeNode builder(int[] preorder, int prei, int prer,
                             int[] postorder, int posi, int posr){
        if(prei > prer || posi > posr) return null;
        if(prei == prer || posi == posr) return new TreeNode(preorder[prei]);

        int cur_val = preorder[prei];
        TreeNode root = new TreeNode(cur_val);

        int target = preorder[prei+1];
        int indexInPos = -1;
        for (int i = posi; i <= posr; i++) {
            if(postorder[i] == target){
                indexInPos = i;
                break;
            }
        }

        int leftSize = indexInPos - posi + 1;

        root.left = builder(preorder, prei +1 , prei + leftSize,
                            postorder, posi , indexInPos);
        root.right = builder(preorder, prei + leftSize +1, prer,
                            postorder, indexInPos +1 , posr - 1);

        return root;
    }
}
