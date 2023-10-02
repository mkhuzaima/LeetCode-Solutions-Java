/*
 * 2037. Minimum Number of Moves to Seat Everyone
 * Problem Link: https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/
 * Difficulty:   Easy
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int sum = 0;
        for (int i = 0; i < seats.length; i++) {
            sum += Math.abs(students[i]-seats[i]);
        }
        return sum;
    }
}
