/*
 * 57. Insert Interval
 * Problem Link: https://leetcode.com/problems/insert-interval/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int index = 0;
        int n = intervals.length;

        List<int[]> result = new ArrayList<>(n);

        // add all smaller intervals
        while (index < n && intervals[index][1] < newInterval[0]) {
            result.add(intervals[index]);
            index++;
        }

        if (index < n)
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);

        while (index < n && newInterval[1] >= intervals[index][0]) {
            index++;
        }

        if (index > 0) {
            newInterval[1] = Math.max(newInterval[1], intervals[index - 1][1]);
        }

        result.add(newInterval);

        // add all larger intervals
        while (index < n) {
            result.add(intervals[index]);
            index++;
        }

        // return the result as array
        return result.toArray(new int[result.size()][]);
    }
}