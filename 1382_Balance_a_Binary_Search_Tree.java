/*
 * 1382. Balance a Binary Search Tree
 * Problem Link: https://leetcode.com/problems/balance-a-binary-search-tree/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        // Create a list to store the nodes in inorder traversal order
        List<TreeNode> list = new ArrayList<>();
        inorderTraversal(list, root);

        // Build a new balanced BST from the list of nodes
        return buildBalancedBST(list, 0, list.size() - 1);
    }

    private void inorderTraversal(List<TreeNode> list, TreeNode node) {
        if (node == null) {
            return;
        }

        // Recursively traverse the left subtree
        inorderTraversal(list, node.left);

        // Add the current node to the list
        list.add(node);

        // Recursively traverse the right subtree
        inorderTraversal(list, node.right);
    }

    private TreeNode buildBalancedBST(List<TreeNode> list, int start, int end) {
        // Base case: no more nodes to add to the subtree
        if (start > end) {
            return null;
        }

        // Select the middle element as the root node
        int mid = (start + end) / 2;
        TreeNode root = list.get(mid);

        // Recursively build the left and right subtrees
        root.left = buildBalancedBST(list, start, mid - 1);
        root.right = buildBalancedBST(list, mid + 1, end);

        return root;
    }
}
