// id: 852
// Name: Peak Index in a Mountain Array
// link: https://leetcode.com/problems/peak-index-in-a-mountain-array/
// Difficulty: Medium

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
