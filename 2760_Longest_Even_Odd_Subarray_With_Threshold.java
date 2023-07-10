/*
 * 2760. Longest Even Odd Subarray With Threshold
 * Problem Link: https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/
 * Difficulty:   Easy
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        
        int result = 0;
        int count = 0;
        int even = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > threshold || nums[i]%2!=even) {
                result = Math.max(count, result);
                count = 0;
                even = 0;
            }
            if (nums[i] <= threshold && nums[i]%2==even) {
                count++;
                even = (even+1)%2;
            }
        }
        result = Math.max(count, result);
        return result;
    }
}
