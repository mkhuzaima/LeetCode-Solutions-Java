/*
 * 228. Summary Ranges
 * Problem Link: https://leetcode.com/problems/summary-ranges/
 * Difficulty:   Easy
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        for (int i =0; i < nums.length; i++) {

            int j = i;
            while (j+1 < nums.length&&nums[j] +1 == nums[j+1]) {
                j++;
            }

            if (i == j) {
                list.add(nums[i] + "");
            }
            else {
                list.add(nums[i] + "->"+nums[j]);
            }

            i = j;
        }

        return list;
    }

}
