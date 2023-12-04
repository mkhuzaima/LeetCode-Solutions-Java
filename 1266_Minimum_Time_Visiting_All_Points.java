/*
 * 1266. Minimum Time Visiting All Points
 * Problem Link: https://leetcode.com/problems/minimum-time-visiting-all-points/
 * Difficulty:   Easy
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;
        
        for (int i = 1; i < points.length; i++) {
            result += Math.max(Math.abs(points[i][0] - points[i-1][0]), Math.abs(points[i][1] - points[i-1][1]));
        }
        return result;
    }
}

