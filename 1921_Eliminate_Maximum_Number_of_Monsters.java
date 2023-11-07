/*
 * 1921. Eliminate Maximum Number of Monsters
 * Problem Link: https://leetcode.com/problems/eliminate-maximum-number-of-monsters/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double [] time = new double[n];

        for (int i = 0; i < n; i++) {
            time[i] = dist[i]*1.0 / speed[i];
        }

        Arrays.sort(time);

        int i = 0;
        while (i < n && time[i] > i) {
            i++;
        }
        return i;
    }
}
