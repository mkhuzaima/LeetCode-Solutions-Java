/*
 * 21. Merge Two Sorted Lists
 * Problem Link: https://leetcode.com/problems/merge-two-sorted-lists/
 * Difficulty:   Easy
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // make dummy node
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            }
            else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // only 1 of the following if will run
        if (list1 != null) {
            tail.next = list1;
        }
        if (list2 != null) {
            tail.next = list2;
        }

        return head.next;
    }
}
