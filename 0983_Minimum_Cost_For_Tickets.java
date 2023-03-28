/*
 * 983. Minimum Cost For Tickets
 * Problem Link: https://leetcode.com/problems/minimum-cost-for-tickets/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Queue<int[]> last7 = new LinkedList<>();    // stores last 7 days
        Queue<int[]> last30 = new LinkedList<>();   // stores last 30 days
        int cost = 0;

        for (int d : days) {
            while (!last7.isEmpty() && d -7 >= last7.peek()[0]) {
                last7.poll();
            }
            while (!last30.isEmpty() && d-30 >= last30.peek()[0]) {
                last30.poll();
            }
            last7.offer(new int[]{d, cost + costs[1]});
            last30.offer(new int[]{d, cost + costs[2]});
            cost = Math.min(cost + costs[0], Math.min(last7.peek()[1], last30.peek()[1]));
        }

        return cost;
    }
}
