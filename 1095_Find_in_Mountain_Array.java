// id: 1095
// Name: Find in Mountain Array
// link: https://leetcode.com/problems/find-in-mountain-array/
// Difficulty: Hard

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {

    private boolean isAscending = true;

    private boolean shouldGoRight(int current, int target) {
        if (isAscending) {
            return current < target;
        } else {
            return current > target;
        }
    }


    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = 0;
        int left = 0;
        int right = mountainArr.length() - 1;

        while (left < right) {
            int mid = ( left + right ) / 2;

            int current = mountainArr.get(mid);
            int leftOfMid = mountainArr.get(mid-1);
            int rightOfMid = mountainArr.get(mid+1);


            // check if at left peak
            if (current > leftOfMid && current > rightOfMid) {
                peakIndex = mid;
                break;
            } else if (current > leftOfMid) {
                // peak is at right
                left = mid ;
            } else if (current > rightOfMid) {
                right = mid ;
            }
        }

        int result = binarySearch(target, mountainArr, 0, peakIndex);

        isAscending = false;

        if (result == -1) {
            result = binarySearch(target, mountainArr, peakIndex, mountainArr.length()-1);
        }

        return result;
    }


    // both start, and end, inclusive
    private int binarySearch(int target, MountainArray mountainArr, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int current = mountainArr.get(mid);

            if (current == target) {
                return mid;
            } else if (shouldGoRight(current, target)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
