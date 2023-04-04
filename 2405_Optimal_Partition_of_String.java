/*
 * 2405. Optimal Partition of String
 * Problem Link: https://leetcode.com/problems/optimal-partition-of-string/description/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int partitionString(String s) {
        
        // create a set
        Set<Character> uniqueLetters = new HashSet<>();

        int min = 1;    // string length will be at least 1

        for (int i = 0; i < s.length(); i++ ) {
            if ( !uniqueLetters.add(s.charAt(i)) ) {
                uniqueLetters.clear();
                uniqueLetters.add(s.charAt(i));
                min++;
            }
        }

        return min;
    }
}
