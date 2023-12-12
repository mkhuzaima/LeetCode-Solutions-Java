/*
 * 42. Trapping Rain Water
 * Problem Link: https://leetcode.com/problems/trapping-rain-water/description/
 * Difficulty:   Hard
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int [] rightMaxes = new int[n]; // maximum height at right of index i
        rightMaxes[n-1] = 0; // no element right

        for (int i = n-2; i >= 0; i--) {
            rightMaxes[i] = Math.max(height[i+1], rightMaxes[i+1]);
        }


        int result = 0;
        int leftMax = height[0];
        for (int i = 1; i < height.length-1; i++) {
            // max right, max left
            int current = Math.min(rightMaxes[i], leftMax) - height[i];

            if (current > 0) result += current;
            
            leftMax = Math.max(leftMax, height[i]);
        }

        return result;
    }
}
