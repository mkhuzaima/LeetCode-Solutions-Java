/*
 * 2038. Remove Colored Pieces if Both Neighbors are the Same Color
 * Problem Link: https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/description/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public boolean winnerOfGame(String colors) {
        int aliceMoves = 0;
        int bobMoves = 0;
        
        for (int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i-1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i+1)) {
                if (colors.charAt(i) == 'A') {
                    aliceMoves++;
                } else {
                    bobMoves++;
                }
            }
        }

        return aliceMoves > bobMoves;
    }
}
