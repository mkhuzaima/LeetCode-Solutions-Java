// id: 2220
// Name: Minimum Bit Flips to Convert Number
// link: https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
// Difficulty: Easy

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
