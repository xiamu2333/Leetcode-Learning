package com.leetcode.labuladong.ListNode;

import sun.security.util.Length;

import java.util.PriorityQueue;

public class Solution_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }

        ListNode res = new ListNode(-1);
        ListNode p = res;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, (a, b) -> (
            a.val - b.val
        ));

        for (ListNode list : lists) {
            if (list != null){
                priorityQueue.add(list);
            }
        }

        while (!priorityQueue.isEmpty()){
            ListNode temp = priorityQueue.poll();
            p.next = temp;
            p = p.next;
            temp = temp.next;

            if (temp != null){
                priorityQueue.add(temp);
            }
        }

        return res.next;
    }
}
