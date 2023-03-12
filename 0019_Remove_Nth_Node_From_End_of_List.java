// id: 19
// Name: Remove Nth Node From End of List
// link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// Difficulty: Medium

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