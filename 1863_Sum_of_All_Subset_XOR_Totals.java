/*
 * 1863. Sum of All Subset XOR Totals
 * Problem Link: https://leetcode.com/problems/sum-of-all-subset-xor-totals/
 * Difficulty:   Easy
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int subsetXORSum(int[] nums) {
        return subsetSum(nums, 0, 0);
    }

    private int subsetSum(int [] nums, int i, int xor) {
        if (i == nums.length) return xor;

        int include = subsetSum(nums, i+1, nums[i] ^ xor);
        int exclude = subsetSum(nums, i+1, xor);
        return include + exclude;
    }
}
