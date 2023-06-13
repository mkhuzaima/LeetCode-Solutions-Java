/*
 * 2352. Equal Row and Column Pairs
 * Problem Link: https://leetcode.com/problems/equal-row-and-column-pairs/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    // brute force approach
    public int equalPairs(int[][] grid) {
        int count = 0;

        int n = grid.length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                // compare row r and column c

                int k = 0; 
                while (k < n && grid[r][k] == grid[k][c]) {
                    k++;
                }
                if ( k == n) {
                    count++;
                }
            }
        }
        return count;
    }
}
