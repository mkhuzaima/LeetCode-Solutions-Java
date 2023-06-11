/*
 * 994. Rotting Oranges
 * Problem Link: https://leetcode.com/problems/rotting-oranges/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    int m, n;
    int [][]grid;
    
    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        int rottenCount = 0;
        int freshCount = 0;

        // apply bfs on grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if it is rotten orange
                if (grid[i][j] == 2) {
                    rottenCount++;
                    q.add(new int[]{i,j});
                }
                else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) {
            return 0; 
        }
        if (q.isEmpty()) {
            return -1;  // no rotten orange
        }
        
        int minuteCount = -1;
        // simultaneously apply bfs from all rotten oranges 
        // (i.e, level order traversal)
        while (!q.isEmpty()) {
            int count = q.size();

            while (count > 0) {
                int [] cell = q.remove();
                int i = cell[0];
                int j = cell[1];
                    
                addIfValid(q, i-1, j);
                addIfValid(q, i+1, j);
                addIfValid(q, i, j-1);
                addIfValid(q, i, j+1);
                count--;
            }
            minuteCount++;
        }
        
        // all grid elements should be empty now
        for (int [] row: grid) {
            for (int c: row) {
                if (c == 1) return -1;
            }
        }
        
        if (minuteCount < 0) minuteCount = 0;
        
        return minuteCount;
    }
    
    private void addIfValid(Queue<int[]> q, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        // empty 
        if (grid[i][j] == 0 || grid[i][j] == 2) {
            return;
        }

        grid[i][j]=0;
        
        q.add(new int[]{i,j});
    }
}
