/*
 * 94. Binary Tree Inorder Traversal
 * Problem Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
 * Difficulty:   Easy
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // create a list to store the result of the inorder traversal
        List<Integer> list = new ArrayList<>();
        // call the helper function to perform the traversal
        inorderHelper(list, root);
        // return the resulting list
        return list;
    }
    
    private void inorderHelper(List<Integer> list, TreeNode root) {
        // base case: if the root is null, there's nothing to traverse
        if (root == null) return;
        
        // recursively traverse the left subtree
        inorderHelper(list, root.left);
        
        // add the root node's value to the list
        list.add(root.val);
        
        // recursively traverse the right subtree
        inorderHelper(list, root.right);
    }
}