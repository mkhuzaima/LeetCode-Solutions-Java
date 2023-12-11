/*
 * 1287. Element Appearing More Than 25% In Sorted Array
 * Problem Link: https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 * Difficulty:   Easy
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int findSpecialInteger(int[] arr) {
        int c = arr.length / 4;

        int current = arr[0];
        int count = 0;
        for (int i: arr) {
            if (i == current) {
                count++;
                if (count > c) return i;
            } else {
                current = i;
                count = 1;
            }
        }
        return -1;
    }
}
