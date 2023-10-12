/*
 * 852. Peak Index in a Mountain Array
 * Problem Link: https://leetcode.com/problems/peak-index-in-a-mountain-array/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int peakIndex = 0;
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = ( left + right ) / 2;

            // check if at left peak
            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
                    peakIndex = mid;
                    break;
            } else if (arr[mid] > arr[mid-1]) {
                // peak is at right
                left = mid ;
            } else if (arr[mid] > arr[mid+1]) {
                right = mid ;
            }
        }


        return peakIndex;
    }
}
