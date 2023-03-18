// id: 99
// Name: Recover Binary Search Tree
// link: https://leetcode.com/problems/recover-binary-search-tree/
// Difficulty: Medium

class Solution {

    // These variables are used to keep track of the two nodes that need to be swapped
    TreeNode first = null;
    TreeNode second = null;
    // This variable is used to keep track of the previously visited node
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        // Perform a Morris traversal of the tree to identify the two nodes that need to be swapped
        morrisTraversal(root);

        // Swap the values of the two identified nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    // This method performs a Morris traversal of the tree
    private void morrisTraversal(TreeNode current) {
        // Base case: if the current node is null, return
        if (current == null) return;

        // Traverse the tree using Morris traversal
        while (current != null) {
            // If the left child of the current node is null, print the current node and move to the right child
            if (current.left == null) {
                // print current
                updateNodes(current);
                current = current.right;
            }
            else {
                // Find the rightmost node in the left subtree
                TreeNode node = current.left;
                while (node.right != null && node.right != current) {
                    node = node.right;
                }
                // If the right child of the rightmost node is null, set it to the current node and move to the left child
                if (node.right == null) {
                    node.right = current;
                    current = current.left;
                }
                // If the right child of the rightmost node is the current node, set it to null, print the current node, and move to the right child
                else {
                    node.right = null;
                    // print current
                    updateNodes(current);
                    current = current.right;
                }
            }
        }
    }

    // This method updates the first and second nodes that need to be swapped
    private void updateNodes(TreeNode node) {
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }
        prev = node;
    }
}