/*
 * 2957. Remove Adjacent Almost-Equal Characters
 * Problem Link: https://leetcode.com/problems/remove-adjacent-almost-equal-characters
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int count = 0;
        for (int i = 1; i < word.length(); i++) {
            if (Math.abs(word.charAt(i) - word.charAt(i-1)) <= 1) {
                i++;
                count++;
            }
        }

        return count;
    }
}
