/*
 * 19. Remove Nth Node From End of List
 * Problem Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }

        if (size == n) {
            return head.next;
        }

        size -= n;
        node = head;
        for (int i = 1; i < size; i++) {
            node = node.next;
        }

        node.next = node.next.next;

        return head;
    }
}