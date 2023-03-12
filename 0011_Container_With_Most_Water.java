// id: 11
// Name: Container With Most Water
// link: https://leetcode.com/problems/container-with-most-water/
// Difficulty: Medium

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int width = height.length - 1;
        int max = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                max = Math.max(width*height[left], max);
                left++;
            }
            else {
                max = Math.max(width*height[right], max);
                right--;
            }
            width--;
        }

        return max;
    }
}