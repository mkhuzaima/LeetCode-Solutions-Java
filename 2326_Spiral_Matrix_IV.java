/*
 * 2326. Spiral Matrix IV
 * Problem Link: https://leetcode.com/problems/spiral-matrix-iv/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {

        int[][] result = new int[m][n];

        for (int [] row: result) {
            Arrays.fill(row, -1);
        }

        int left=0,right=n-1,top=0, bottom=m-1;

        while (head != null) {

            for (int k=left; k<= right && head != null;k++) {
                result[top][k] = head.val;
                head = head.next;
            }
            top++;

            for (int k=top; k<=bottom && head != null; k++) {
                result[k][right] = head.val;
                head = head.next;
            }
            right--;
            
            for (int k=right; k>=left && head != null; k--) {
                result[bottom][k] = head.val;
                head = head.next;
            }
            bottom--;
            
            for (int k=bottom; k>=top && head != null;k--) {
                result[k][left] = head.val;
                head = head.next;
            }
            left++;

        
        }

        return result;
    }
}
