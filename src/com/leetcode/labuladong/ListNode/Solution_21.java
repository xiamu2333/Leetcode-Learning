package com.leetcode.labuladong.ListNode;

public class Solution_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }
        ListNode res = new ListNode();
        ListNode result = res;
        ListNode l1 = list1;
        ListNode l2 = list2;

        while (l1 != null && l2 != null){
            ListNode tempNode;
            if (l1.val <= l2.val){
                tempNode = l1;
                l1 = l1.next;
            }else {
                tempNode = l2;
                l2 = l2.next;
            }

            res.next = tempNode;
            res = res.next;
        }

        if (l1 == null){
            res.next = l2;
        }else {
            res.next = l1;
        }

        return result.next;
    }
}
