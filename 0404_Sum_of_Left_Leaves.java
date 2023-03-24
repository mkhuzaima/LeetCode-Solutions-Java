/*
 * 404. Sum of Left Leaves
 * Problem Link: https://leetcode.com/problems/sum-of-left-leaves/
 * Difficulty:   Easy
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        preorder(root, false);
        return sum;
    }

    private void preorder(TreeNode node, boolean isLeft) {
        if (node == null) return;
        if (isLeft && node.left == null && node.right == null) {
            sum += node.val;
        }

        preorder(node.left, true);
        preorder(node.right, false);
    }
}
