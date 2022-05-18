package com.leetcode.labuladong.Tree;

public class Solution_912_MyMergeSort {
    public int[] sortArray(int[] nums) {
        MyMergeSort mergeSort = new MyMergeSort();
        mergeSort.sort(nums);
        return nums;
    }
}

class MyMergeSort{
    int[] temp;
    public void sort(int[] nums){
        temp = new int[nums.length];
        sort(nums, 0, nums.length -1);
    }
    private void sort(int[] nums, int left, int right){
        if(left == right) return ;
        int mid = left + (right - left)/2;
        
        sort(nums, left, mid);
        sort(nums, mid+1, right);
        
        merge(nums, left, mid,  right);
    }
    private void merge(int[] nums, int left, int mid, int right){
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        
        int i = left;
        int j = mid +1;

        for (int p = left; p <= right; p++) {
            if(i > mid || temp[i] - temp[j] > 0){
                nums[p] = temp[j++];
            }
            else if(j > right || temp[i] - temp[j] <= 0){
                nums[p] = temp[i++];
            }
        }
        
    }
}