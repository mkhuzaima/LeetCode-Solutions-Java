/*
 * 2090. K Radius Subarray Averages
 * Problem Link: https://leetcode.com/problems/k-radius-subarray-averages/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int[] getAverages(int[] nums, int k) {

        int subArraySize = 2 * k + 1;

        int n = nums.length;

        // create a result array
        int [] result = new int[n];
        
        int i = 0;

        long sum = 0;

        while ( i < k && i < n) {
            result[i] = -1;
            sum += nums[i];
            i++;
        }

        // add k more elements to the sum
        for (int j = i; j < k+i && j < n; j++) {
            sum += nums[j];
        }

        while (i+k<n) {
            // add the rightmost element 
            sum += nums[i+k];

            result[i] = (int)(sum/subArraySize);

            // remove element from left
            sum -= nums[i-k];

            i++;
        }

        while ( i < n) {
            result [i] = -1;
            i++;
        }

        return result;
    }
}
