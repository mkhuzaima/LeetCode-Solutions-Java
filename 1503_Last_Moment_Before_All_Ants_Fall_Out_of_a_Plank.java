/*
 * 1503. Last Moment Before All Ants Fall Out of a Plank
 * Problem Link: https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        // calcualte time taken by each ant to move to edge
        
        // store largest
        int result = 0;

        for (int l: left) {
            if (l > result) result = l;
        }

        for (int r: right) {
            if (n-r > result) result = n-r;
        }

        return result;
    }
}
