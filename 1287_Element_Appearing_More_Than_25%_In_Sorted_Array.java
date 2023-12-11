// id: 1287
// Name: Element Appearing More Than 25% In Sorted Array
// link: https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
// Difficulty: Easy

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
