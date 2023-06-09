/*
 * 744. Find Smallest Letter Greater Than Target
 * Problem Link: https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 * Difficulty:   Easy
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        int start = 0;
        int end = letters.length-1;
        int mid;

        while (start <= end) {
            mid = (start+end)/2;

            // should be greater than target
            if (letters[mid] <= target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        // start will be n if all elements are smaller.
        return letters[start % letters.length];
    }
}
