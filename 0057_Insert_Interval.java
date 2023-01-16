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

        int[][] result = new int[n+1][2];

        while (index < n && intervals[index][1] < newInterval[0]) {
            result[index] = intervals[index];
            index++;
        }

        if (index < n) 
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);

        result[index][0] = newInterval[0];


        int j = index ;
        while(j < n && newInterval[1] >= intervals[j][0]){
            j++;
        } 


        if (j > 0){
            newInterval[1] = Math.max(newInterval[1], intervals[j-1][1]);
        }

        result[index++][1] = newInterval[1];

        while(j < n) {
            result[index++] = intervals[j++];
        }

        if ( index == n +1) {   // resize not needed
            return result;
        }

        // resize the array
        int [][]newResult = new int[index][2];
        for (int i = 0; i < index; i++) {
            newResult[i] = result[i];
        }
        return newResult;
    }
}