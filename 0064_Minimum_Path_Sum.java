/*
 * 64. Minimum Path Sum
 * Problem Link: https://leetcode.com/problems/minimum-path-sum/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
  public int minPathSum(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    int[][] dp = new int[n][m];

    dp[0][0] = grid[0][0];

    for (int i = 1; i < n; i++)
      dp[i][0] = dp[i - 1][0] + grid[i][0];

    for (int j = 1; j < m; j++)
      dp[0][j] = dp[0][j - 1] + grid[0][j];

    for (int i = 1; i < n; i++)
      for (int j = 1; j < m; j++)
        dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);

    return dp[n - 1][m - 1];
  }

}
