package com.leetcode.labuladong.Tree;
/*解题思路：
*   分析：
*       题目要求区间和落在某范围内，可以将区间和转化为前缀和之差，减少求区间和的时间复杂度。
*       于是区间和问题变成了，某元素后有几个元素与其之差落在某区间内。
*       某元素后有几个。。。的问题就可以转化为归并排序，时间复杂度为n*longn，小于n平方。
*       于是考虑在merge阶段，对两个区间进行操作。
*       但是直接遍历的话，会发现时间复杂度变成了n平方。
*       因为merge合并之前，前后两部分数组都是有序的。
*       可以设定一个滑动窗口进行计算。
* */

public class Solution_327 {
    private int count;      //统计结果
    private long[] temp;    //辅助数组，用作归并排序
    private int low;
    private int upp;
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] presum = new long[n+1];  //前缀和数组
        temp = new long[n+1];
        low = lower;
        upp = upper;

        for (int i = 0; i < n; i++) {
            presum[i+1] = presum[i] + nums[i];//计算前缀和
        }

        Mysort(presum, 0 , n);

        return count;
    }
    private void Mysort(long[] presum, int left, int right){
        if (left == right) return;      //递归终止条件

        int mid = left + (right - left)/2;//计算中点，防止溢出
//      递归拆分
        Mysort(presum, left, mid);
        Mysort(presum, mid+1, right);
//      归并排序
        MyMerge(presum, left, mid, right);
    }
    private void MyMerge(long[] presum, int left, int mid, int right){
        for (int i = left; i <= right; i++) {
            temp[i] = presum[i];
        }

        int start = mid+1, end = mid +1;    //滑动窗口
//      统计符合条件的个数
        for (int i = left; i < mid + 1; i++) {
            while (end <= right && presum[end] - presum[i] <= upp){     //注意边界条件
                end++;
            }
            while (start <= right && presum[start] - presum[i] < low){
                start++;
            }
            count += end - start;
        }

        int i = left;
        int j = mid+1;
        //统计完之后归并排序
        for (int p = left; p <= right; p++) {

            if(i == mid+1){
                presum[p] = temp[j++];
            }
            else if (j == right+1){
                presum[p] = temp[i++];
            }
            else if (temp[i] < temp[j]){
                presum[p] = temp[i++];
            }
            else {
                presum[p] = temp[j++];
            }

        }
    }
}
