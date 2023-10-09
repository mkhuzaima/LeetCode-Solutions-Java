// id: 34
// Name: Find First and Last Position of Element in Sorted Array
// link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Difficulty: Medium

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1; // both inclusive

        int [] result = {-1, -1};

        while (low <= high) {
            int mid = (low + high) / 2;

            // mid is in second half;
            if (nums[mid] < target) {
                low = mid+1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                result[0] = first(nums, target, low, mid); // both inclusive
                result[1] = last(nums, target, mid, high); // both inclusive
                
                break; // to break the loop
            }
        }

        return result;
    }

    private int first(int[] nums, int target, int low, int high) {
        int ans = high;
        while (low <= high) {

            int mid = (high + low ) /2;
            if (nums[mid] >= target) {
                high = mid - 1;
                ans = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int last(int[] nums, int target, int low, int high) {
        int ans = low;
        while (low <= high) {

            int mid = (high + low ) /2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] <= target) {
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }
}
