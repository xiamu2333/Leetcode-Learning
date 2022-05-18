package com.leetcode.labuladong.Tree;

public class Solution_912_MyQuickSort {
    public int[] sortArray(int[] nums) {
        MyQuickSort(nums, 0, nums.length-1);
        return nums;
    }
    private void MyQuickSort(int[] nums, int left, int right){
        if (left >= right) return;

        int p = position(nums, left, right);

        MyQuickSort(nums,left, p-1);
        MyQuickSort(nums, p + 1, right);
    }
    private int position(int[] nums, int left, int right){
        int i = left;
        int j = right;
        int temp = nums[left];

        while (i < j){
            while (i < j && nums[j] >= temp){
                j--;
            }
            if(nums[j] < temp) nums[i] = nums[j];
            while (i < j && nums[i] <= temp) i++;
            if (nums[i] > temp) nums[j] = nums[i];
        }

        nums[i] = temp;

        return i;

    }
}
