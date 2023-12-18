/*
 * 1913. Maximum Product Difference Between Two Pairs
 * Problem Link: https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
 * Difficulty:   Easy
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length-1]*nums[nums.length-2]) - (nums[0]*nums[1]);
    }
}
