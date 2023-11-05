// id: 1535
// Name: Find the Winner of an Array Game
// link: https://leetcode.com/problems/find-the-winner-of-an-array-game/
// Difficulty: Medium

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
