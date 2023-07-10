// id: 2760
// Name: Longest Even Odd Subarray With Threshold
// link: https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/
// Difficulty: Easy

class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        
        int result = 0;
        int count = 0;
        int even = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > threshold || nums[i]%2!=even) {
                result = Math.max(count, result);
                count = 0;
                even = 0;
            }
            if (nums[i] <= threshold && nums[i]%2==even) {
                count++;
                even = (even+1)%2;
            }
        }
        result = Math.max(count, result);
        return result;
    }
}
