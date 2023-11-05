/*
 * 1535. Find the Winner of an Array Game
 * Problem Link: https://leetcode.com/problems/find-the-winner-of-an-array-game/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int getWinner(int[] arr, int k) {

        int winner = arr[0];
        int count = 0;

        for (int i = 0; count < k && i < arr.length - 1 ; i++) {
            // calculate winner
            if (winner < arr[i+1]) {
                count = 0;
                winner = arr[i+1];
            }
            count++;
        }
        // if loop terminated by i == arr.length then count is max element

        return winner;
    }
}
