/*
 * 958. Check Completeness of a Binary Tree
 * Problem Link: https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);

        boolean nullNodeFound = false;


        while (!q.isEmpty()) {
            TreeNode n = q.poll();

            if (n == null) {
                // all next nodes should be null
                nullNodeFound = true;
            }
            else {
                if (nullNodeFound) {
                    return false;
                }
                q.add(n.left);
                q.add(n.right);
            }
        }

        return true;
    }
}