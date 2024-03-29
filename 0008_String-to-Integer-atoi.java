/*
 * 8. String to Integer (atoi)
 * Problem Link: https://leetcode.com/problems/string-to-integer-atoi/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int myAtoi(String s) {
        long number = 0;
        boolean isPositive = true;
        int i = 0; 

        while ( i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            isPositive = s.charAt(i) == '+';
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i)) ) {

            number = number * 10 + s.charAt(i) - '0';

            if (number > Integer.MAX_VALUE){
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            i++;
        }

    
        if (!isPositive) number *= -1;
    
        return (int)number;
    }
}