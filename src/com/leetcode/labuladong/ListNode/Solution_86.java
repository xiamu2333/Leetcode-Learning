package com.leetcode.labuladong.ListNode;

public class Solution_86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode temp1 = new ListNode(-1);
        ListNode temp2 = new ListNode(-1);
        ListNode res = temp1;

        while (head != null){
            if (head.val < x){
                temp1.next = head;
                temp1 = temp1.next;
            }else {
                temp2.next = head;
                temp2 = temp2.next;
            }
            head = head.next;
        }

        temp2.next = null;

        temp1.next = temp2.next;

        return res.next;
    }
}
