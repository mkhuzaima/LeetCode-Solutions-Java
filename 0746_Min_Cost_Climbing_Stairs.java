/*
 * 746. Min Cost Climbing Stairs
 * Problem Link: https://leetcode.com/problems/min-cost-climbing-stairs/?envType=daily-question
 * Difficulty:   Easy
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int step_minus_2 = cost[0];  // stores cost till step_minus_2
        int step_minus_1 = cost[1];  // stores cost till step_minus_1 

        for (int i = 2; i < cost.length; i++) {
            // reach ith step from step with minimum cost
            int c =  cost[i] + Math.min(step_minus_2, step_minus_1);

            step_minus_2 = step_minus_1;
            step_minus_1 = c;

        }
        return Math.min(step_minus_2, step_minus_1); 
    }
}
