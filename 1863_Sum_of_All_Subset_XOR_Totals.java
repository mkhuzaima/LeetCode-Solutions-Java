// id: 1863
// Name: Sum of All Subset XOR Totals
// link: https://leetcode.com/problems/sum-of-all-subset-xor-totals/
// Difficulty: Easy

class Solution {
    public int subsetXORSum(int[] nums) {
        return subsetSum(nums, 0, 0);
    }

    private int subsetSum(int [] nums, int i, int xor) {
        if (i == nums.length) return xor;

        int include = subsetSum(nums, i+1, nums[i] ^ xor);
        int exclude = subsetSum(nums, i+1, xor);
        return include + exclude;
    }
}
