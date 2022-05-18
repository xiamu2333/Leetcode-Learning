package com.leetcode.labuladong.Tree;

import java.util.ArrayList;
import java.util.List;

//求无序数组，每个元素后面有多少个比他小
public class Solution_315 {
    MyElements[] numbers;
    MyElements[] temp;
    int[] counts;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        numbers = new MyElements[n];
        temp = new MyElements[n];
        counts = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = new MyElements(nums[i],i);
        }

        Mysort(numbers, 0, n-1);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(counts[i]);
        }

        return res;
    }
    private void Mysort(MyElements[] numbers, int left, int right){
        if (left == right) return;

        int mid = left + (right - left)/2;

        Mysort(numbers, left, mid);
        Mysort(numbers, mid+1, right);

        Merge(numbers, left, mid, right);
    }
    private void Merge(MyElements[] numbers, int left, int mid, int right){
        for (int i = left; i <= right; i++) {
            temp[i] = numbers[i];
        }

        int i = left, j = mid+1;

        for (int p = left; p <= right; p++) {
            if (i == mid+1){
                numbers[p] = temp[j++];
            }
            else if(j == right+1){
                numbers[p] = temp[i++];
                counts[numbers[p].id] += j - mid -1;
            }
            else if(temp[i].val > temp[j].val){
                numbers[p] = temp[j++];
            }
            else if(temp[i].val <= temp[j].val){
                numbers[p] = temp[i++];
                counts[numbers[p].id] += j - mid -1;
            }
        }
    }
}

class MyElements implements Comparable {
    int val;
    int id;

    public MyElements(int val, int id) {
        this.val = val;
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        return this.val - ((MyElements)o).val;
    }
}
