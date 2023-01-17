/*
 * 926. Flip String to Monotone Increasing
 * Problem Link: https://leetcode.com/problems/flip-string-to-monotone-increasing/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int onesTillNow = 0;
        
        // variable to store the result
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                // flip all previous ones, or flip this one
                ans = Math.min(onesTillNow, ans + 1);
            }
            else {
                onesTillNow++;
            }
        }

        // return number of flips
        return ans;
    }
}
