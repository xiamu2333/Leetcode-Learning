package com.leetcode.labuladong.Tree;

import java.util.LinkedList;
import java.util.Queue;
//定义树节点
//定义树与String互相转换的方法
//定义树与整数组互相转换的方法
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}

    TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public String toString(){
        //层序遍历
        String res = "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            int sz = queue.size();

            for (int i = 0; i < sz; i++) {
                TreeNode temp = queue.poll();
                res += temp.val;
                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }

        return res;
    }

    public static TreeNode toTreeNode(String tree){
        char[] chars = tree.toCharArray();
        TreeNode root = new TreeNode(chars[0] - '0');
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<Integer> integerQueue = new LinkedList<>();

        for (int i = 1; i < chars.length; i++) {
            integerQueue.add(chars[i] - '0');
        }

        while (!integerQueue.isEmpty()) {
            TreeNode temp = queue.poll();
            temp.left = new TreeNode(integerQueue.poll());
            queue.add(temp.left);
            if(integerQueue.isEmpty()) break;
            temp.right = new TreeNode(integerQueue.poll());
            queue.add(temp.right);
        }

        return root;
    }

    public Integer[] toIntegers(){
        //层序遍历
        LinkedList<Integer> integers = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            int sz = queue.size();

            for (int i = 0; i < sz; i++) {
                TreeNode temp = queue.poll();
                integers.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        Integer[] res = integers.toArray(new Integer[integers.size()]);
        return res;
    }

    public static TreeNode toTreeNode(int[] ints){
        TreeNode root = new TreeNode(ints[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<Integer> integerQueue = new LinkedList<>();

        for (int i = 1; i < ints.length; i++) {
            integerQueue.add(ints[i]);
        }

        while (!integerQueue.isEmpty()) {
            TreeNode temp = queue.poll();
            temp.left = new TreeNode(integerQueue.poll());
            queue.add(temp.left);
            if(integerQueue.isEmpty()) break;
            temp.right = new TreeNode(integerQueue.poll());
            queue.add(temp.right);
        }

        return root;
    }
}
