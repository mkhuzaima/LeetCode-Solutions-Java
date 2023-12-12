/*
 * 1464. Maximum Product of Two Elements in an Array
 * Problem Link: https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 * Difficulty:   Easy
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int maxProduct(int[] nums) {
        int max = 0;
        int secondMax = 0;
        for (int n: nums) {
            if (n > max) {
                secondMax = max;
                max = n;
            } else if (n > secondMax) {
                secondMax = n;
            }
        }
        return (max-1) * (secondMax-1);
    }
}
