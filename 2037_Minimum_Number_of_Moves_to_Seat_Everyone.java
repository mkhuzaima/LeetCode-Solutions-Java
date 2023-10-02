// id: 2037
// Name: Minimum Number of Moves to Seat Everyone
// link: https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/
// Difficulty: Easy

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
