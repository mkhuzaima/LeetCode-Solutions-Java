// id: 2352
// Name: Equal Row and Column Pairs
// link: https://leetcode.com/problems/equal-row-and-column-pairs/
// Difficulty: Medium

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
