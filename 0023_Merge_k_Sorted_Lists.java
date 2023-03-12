/*
 * 23. Merge k Sorted Lists
 * Problem Link: https://leetcode.com/problems/merge-k-sorted-lists/
 * Difficulty:   Hard
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeListsHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeListsHelper(ListNode[] lists, int start, int end) {
        int mid = (start + end) / 2;
        if (start >= end) return lists[start];

        ListNode first = mergeListsHelper(lists, start, mid);
        ListNode second = mergeListsHelper(lists, mid+1, end);
        return merge2Lists(first, second);
    }

    private ListNode merge2Lists(ListNode first, ListNode second) {
        // make dummy node for easier addition
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        
        
        while (first != null && second != null) {
            if (first.val < second.val) {
                tail.next = first;
                first = first.next;
            }
            else {
                tail.next = second;
                second = second.next;
            }
            tail = tail.next;
        }

        // only 1 of the following if will run
        if (first != null) {
            tail.next = first;
        }
        if (second != null) {
            tail.next = second;
        }

        return head.next;
    }
  
  
  
  
    //////////////////////////////////// SECOND APPROACH
    /*
    public ListNode mergeKLists(ListNode[] lists) {

        // create a list object for merged lists
        ListNode head = null;
        ListNode tail = null;

        while (true) {
            // find the minimum elment from lists
            int minNodeIndex = -1;

            // minimum can also be fined using Priority Queue
            // but PrioriryQueue will use extra space

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) continue;

                if (
                    minNodeIndex == -1 || // not initialized
                    lists[i].val < lists[minNodeIndex].val 
                ){
                    minNodeIndex = i;
                }
            }

            if (minNodeIndex == -1) {
                break; // all lists are merged
            }
            else {
                if ( head == null ) {
                    head = tail = lists[minNodeIndex];
                }
                else {
                    tail.next = lists[minNodeIndex];
                    tail = tail.next;
                }
                lists[minNodeIndex] = lists[minNodeIndex].next;
            }
        }
        
        return head;
    }
    */
}
