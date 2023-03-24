/*
 * 199. Binary Tree Right Side View
 * Problem Link: https://leetcode.com/problems/binary-tree-right-side-view/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // right side view means the rightmost element of each level

        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }

        while (!q.isEmpty()) {
            int count = q.size();
            // traverse the complete level
            while (count > 0) {
                root = q.poll();

                if (root.left != null) {
                    q.add(root.left);
                }
                if (root.right != null) {
                    q.add(root.right);
                }
                count--;
            }
            // add the last level to the result
            result.add(root.val);
        }

        return result;
    }
}
