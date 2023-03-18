// id: 98
// Name: Validate Binary Search Tree
// link: https://leetcode.com/problems/validate-binary-search-tree/
// Difficulty: Medium

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root.left, null, root.val) && isValidBST(root.right, root.val, null);
    }

    /**
     * Checks if a subtree is a valid binary search tree.
     * @param root the root node of the subtree to be checked
     * @param low the minimum value of the subtree, exclusive
     * @param high the maximum value of the subtree, exclusive
     * @return true if the subtree is a valid binary search tree, false otherwise
     */
    public boolean isValidBST(TreeNode root, Integer low, Integer high) {
        // Base case: an empty subtree is a valid BST
        if (root == null) {
            return true;
        }

        // Check if the value of the root node is within the valid range
        if (low != null && root.val <= low || high != null && root.val >= high) {
            return false;
        }

        // Recursively check if the left and right subtrees are valid BSTs,
        // restricting the valid range of values for each subtree
        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
    }
}
