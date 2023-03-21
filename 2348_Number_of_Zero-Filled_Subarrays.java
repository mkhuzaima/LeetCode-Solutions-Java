// id: 2348
// Name:  Number of Zero-Filled Subarrays
// link: https://leetcode.com/problems/number-of-zero-filled-subarrays/
// Difficulty: Medium

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