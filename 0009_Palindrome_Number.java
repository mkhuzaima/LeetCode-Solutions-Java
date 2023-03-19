/*
 * 9. Palindrome Number
 * Problem Link: https://leetcode.com/problems/palindrome-number/
 * Difficulty:   Easy
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reverted = 0;
        while (x > reverted) {
            reverted = 10*reverted + x%10;
            x /= 10;
        }


        return x == reverted || x == reverted / 10;
    }
}
