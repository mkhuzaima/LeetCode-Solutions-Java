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

        int zeroes = 0;
        int ones = 0;

        // move right until first 1 is found
        int i;
        for (i = 0; i < s.length() && s.charAt(i) != '1'; i++);


        // if all zeroes, no swap required
        if (i == s.length()) return 0;

        int j;
        for (j = s.length() - 1 ; j >= 0 && s.charAt(j) != '0'; j--);

        // if all 1, no swap required
        if (j == 0) return 0;

        int result = 0;
        while (i <= j) {
            if (s.charAt(i) == '0') {
                zeroes++;
            }
            else {
                ones++;
            }

            // if zeroes are more than 1, flip all 1s
            if (zeroes > ones) {
                result += ones;
                zeroes = ones = 0;      // reset count

                // skip all zeroes
                while (i <= j && s.charAt(i) == '0') {
                    i++;
                }
            }
            else {
                i++;
            }
        }

        // convert all 0s to 1s, or all 1s to 0s.
        return result + Math.min(ones, zeroes);
    }
}
