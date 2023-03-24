/*
 * 653. Two Sum IV - Input is a BST
 * Problem Link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * Difficulty:   Easy
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        
        if (root == null) return false;

        if (set.contains(k - root.val)) {
            return true;
        } 

        set.add(root.val);

        return findTarget(root.left, k) || findTarget(root.right, k);
    }   
}
