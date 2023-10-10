/*
 * 2220. Minimum Bit Flips to Convert Number
 * Problem Link: https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
 * Difficulty:   Easy
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int minBitFlips(int start, int goal) {
        int result = start ^ goal; // bitwise xor

        int flipCount = 0;
        // count number of 1
        while (result > 0) {
            if ((result &1) == 1) 
                flipCount++;
            result >>= 1;
        }

        return flipCount;
    }
}
