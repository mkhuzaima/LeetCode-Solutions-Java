/*
 * 382. Linked List Random Node
 * Problem Link: https://leetcode.com/problems/linked-list-random-node/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */


class Solution {
    Random random;
    ListNode head;
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }
    
    public int getRandom() {
        ListNode temp = head;

        int result = 0;
        int len = 1;

        while (temp != null) {
            if (random.nextInt() % len == 0) {
                result = temp.val;
            }
            len++;
            temp = temp.next;
        }
        return result;
    }
}
