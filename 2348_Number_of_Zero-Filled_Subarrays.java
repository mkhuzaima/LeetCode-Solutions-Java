/*
 * 2348.  Number of Zero-Filled Subarrays
 * Problem Link: https://leetcode.com/problems/number-of-zero-filled-subarrays/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long result = 0;
        long consecutiveZeroesCount = 0;

        for (int n: nums) {
            if (n == 0){
                consecutiveZeroesCount ++;
                // number of subarrays that end at current element
                // is equal to size of consecutive zeroes
                result += consecutiveZeroesCount;
            }
            else {
                consecutiveZeroesCount = 0;
            }
        }
        return result;
    }
}