// id: 32
// Name: Longest Valid Parentheses
// link: https://leetcode.com/problems/longest-valid-parentheses/
// Difficulty: Hard

class Solution {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (right == left) {
                result = Math.max(result, 2 * left);
            } else if (right > left) {  // ())
                left = right = 0;
            }
        }


        // for cases like ()(()
        // also count from backwards

        left = right = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            System.out.println("left="+left+", right = " +right);
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (right == left) {
                result = Math.max(result, 2 * left);
            } else if (left > right) {  // (()
                left = right = 0;
            }
        }
        return result;
    }
}
