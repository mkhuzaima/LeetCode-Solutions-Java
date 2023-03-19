/*
 * 142. Linked List Cycle II
 * Problem Link: https://leetcode.com/problems/linked-list-cycle-ii/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Initialize two pointers, fast and slow, to the head of the linked list
        ListNode fast = head;
        ListNode slow = head;

        // Move fast and slow pointers until they meet or fast reaches the end of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If there is a cycle, move slow pointer back to head and find the cycle start point
            if (slow == fast) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // Return the node where the cycle starts
                return slow;
            }
        }

        // If there is no cycle, return null
        return null;
    }
}
