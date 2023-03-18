/*
 * 101. Symmetric Tree
 * Problem Link: https://leetcode.com/problems/symmetric-tree/
 * Difficulty:   Easy
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }
    private boolean check(TreeNode n1, TreeNode n2) {
        // if both are null
        if (n1 == null && n2 == null) return true;
        // if only 1 is null
        if (n1 == null || n2 == null) return false;
        
        // check values and do same for children
        return (n1.val == n2.val) && 
            check(n1.left, n2.right) && check(n1.right, n2.left);
    }
}
