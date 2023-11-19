/*
 * 1887. Reduction Operations to Make the Array Elements Equal
 * Problem Link: https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);

        int result = 0;

        int count = 0;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                count++;
            }
            result += count;
        }
        return result;
    }
}
