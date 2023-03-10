// id: 382
// Name: Linked List Random Node
// link: https://leetcode.com/problems/linked-list-random-node/
// Difficulty: Medium


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
