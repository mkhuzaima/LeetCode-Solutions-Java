/*
 * 100. Same Tree
 * Problem Link: https://leetcode.com/problems/same-tree/
 * Difficulty:   Easy
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // if both are same (null)
        if (p == q) return true;

        // both are different
        // if only 1 is null
        if (p == null || q == null) return false;

        // self explanatory
        return (p.val == q.val) &&
                    isSameTree(p.left, q.left) &&  
                    isSameTree(p.right, q.right);
    }
}
