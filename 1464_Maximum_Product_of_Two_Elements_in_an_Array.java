// id: 1464
// Name: Maximum Product of Two Elements in an Array
// link: https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
// Difficulty: Easy

class Solution {
    public int maxProduct(int[] nums) {
        int max = 0;
        int secondMax = 0;
        for (int n: nums) {
            if (n > max) {
                secondMax = max;
                max = n;
            } else if (n > secondMax) {
                secondMax = n;
            }
        }
        return (max-1) * (secondMax-1);
    }
}
