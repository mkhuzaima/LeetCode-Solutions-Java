/*
 * 513. Find Bottom Left Tree Value
 * Problem Link: https://leetcode.com/problems/find-bottom-left-tree-value/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        if (root != null) {
            q.add(root);
        }

        int leftMost = 0;

        while (!q.isEmpty()) {
            int count = q.size();
            leftMost = q.peek().val;

            while (count > 0) {
                root = q.poll();
                if (root.left != null) q.add(root.left);
                if (root.right != null) q.add(root.right);
                count--;
            }
        }
        return leftMost;
    }
}
