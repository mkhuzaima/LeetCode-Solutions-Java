// id: 1913
// Name: Maximum Product Difference Between Two Pairs
// link: https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
// Difficulty: Easy

class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length-1]*nums[nums.length-2]) - (nums[0]*nums[1]);
    }
}
