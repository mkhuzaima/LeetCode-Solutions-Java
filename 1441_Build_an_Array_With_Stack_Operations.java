/*
 * 1441. Build an Array With Stack Operations
 * Problem Link: https://leetcode.com/problems/build-an-array-with-stack-operations/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public List<String> buildArray(int[] target, int n) {
        int j = 0;
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n && j < target.length; i++) {
            if (i == target[j] ) {
                result.add("Push");
                j++;
            } else {
                result.add("Push");
                result.add("Pop");
            }
        }


        return result;

    }
}
