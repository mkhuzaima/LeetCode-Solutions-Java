/*
 * 91. Decode Ways
 * Problem Link: https://leetcode.com/problems/decode-ways
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int numDecodings(String s) {
        int dp1 = s.charAt(s.length()-1) == '0' ? 0: 1;
        int dp2 = 1; // empty string

        for (int i = s.length()-2; i >= 0; i--) {
            int current = 0;
            if (s.charAt(i) != '0') {
                current += dp1;

                if (Integer.parseInt(s.substring(i, i+2)) <= 26) {
                    current += dp2;
                }
            }
            dp2 = dp1;
            dp1 = current;
        }
        return dp1;
    }
}
