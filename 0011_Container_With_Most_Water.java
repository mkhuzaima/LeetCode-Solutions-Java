/*
 * 11. Container With Most Water
 * Problem Link: https://leetcode.com/problems/container-with-most-water/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int width = height.length - 1;
        int max = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                max = Math.max(width*height[left], max);
                left++;
            }
            else {
                max = Math.max(width*height[right], max);
                right--;
            }
            width--;
        }

        return max;
    }
}