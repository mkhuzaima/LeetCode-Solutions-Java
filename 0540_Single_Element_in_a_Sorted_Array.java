// id: 540
// Name: Single Element in a Sorted Array
// link: https://leetcode.com/problems/single-element-in-a-sorted-array/
// Difficulty: Medium

class Solution {
    public int singleNonDuplicate(int[] nums) {

        // it is guarrenteed that length is odd (2x+1)
        int high = nums.length;
        int low = 0;

        int mid = high/2;

        while (high > low +1) {
            if (mid % 2 != 0) {
                mid--;
            }

            // second half
            if (nums[mid] == nums[mid+1]) {
                low = mid+2; // mid and mid+1 are same
            }
            // first half
            else {
                high = mid;
            }

            mid = (high-low)/2 + low;
        }

        return nums[mid];
    }
}
