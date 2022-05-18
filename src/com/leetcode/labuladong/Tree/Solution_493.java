package com.leetcode.labuladong.Tree;

public class Solution_493 {
    int[] temp;
    int count;

    public int reversePairs(int[] nums) {
        int n = nums.length;
        temp = new int[n];
        count = 0;

        Mysort(nums, 0, n-1);

        return count;
    }
    private void Mysort(int[] numbers, int left, int right){
        if (left == right) return;

        int mid = left + (right - left)/2;

        Mysort(numbers, left, mid);
        Mysort(numbers, mid+1, right);

        Merge(numbers, left, mid, right);
    }
    private void Merge(int[] numbers, int left, int mid, int right){
        for (int i = left; i <= right; i++) {
            temp[i] = numbers[i];
        }

        int end = mid + 1;
        for (int i = left; i < mid + 1; i++) {
            while (end <= right && (long)numbers[i] > (long) 2 * numbers[end]){
                end++;
            }
            count += end - mid -1;
        }

        int i = left, j = mid+1;

        for (int p = left; p <= right; p++) {
            if (i == mid+1){
                numbers[p] = temp[j++];
            }
            else if(j == right+1){
                numbers[p] = temp[i++];
            }
            else if(temp[i] > temp[j]){
                numbers[p] = temp[j++];
            }
            else if(temp[i] <= temp[j]){
                numbers[p] = temp[i++];
            }
        }
    }
}