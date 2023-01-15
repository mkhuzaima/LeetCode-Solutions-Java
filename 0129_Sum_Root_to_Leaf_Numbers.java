/*
 * 129. Sum Root to Leaf Numbers
 * Problem Link: https://leetcode.com/problems/sum-root-to-leaf-numbers
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // method to calculate the sum of all the numbers formed by the path from the root to a leaf node
    public int sumNumbers(TreeNode root) {
        // call the helper method to traverse the tree and calculate the sum
        return traversal(root, 0);
    }

    private int traversal(TreeNode root, int parentValue) {
        // base case: if current node is null, return 0
        if (root == null) return 0;
        
        // if current node is a leaf node, return the value of the path from the root to this leaf node
        if (root.left == null && root.right == null) {
            return 10*parentValue + root.val;
        }
        
        // recursively call the traversal method on left and right subtrees and add the returned values
        return traversal(root.left, 10*parentValue + root.val) +
            traversal(root.right, 10*parentValue + root.val);
    }
}
