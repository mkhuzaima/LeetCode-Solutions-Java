// id: 1609
// Name: Even Odd Tree
// link: https://leetcode.com/problems/even-odd-tree/
// Difficulty: Medium

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        // Create a queue to store the nodes to be processed in level-order
        Queue<TreeNode> q = new LinkedList<>();

        // Add the root node to the queue to start processing
        q.add(root);

        // Initialize the level to 0 (even)
        int level = 0;

        while (!q.isEmpty()) {
            // Get the number of nodes in the current level
            int count = q.size();

            // Initialize a variable to store the value of the previous node in the same level
            Integer prev = null;

            while (count > 0) {
                // Get the next node in the queue
                TreeNode current = q.poll();

                // Check if the value of the node violates the level-specific constraints
                if (current.val % 2 == level ) {
                    return false;
                }

                // Check if the value of the node violates the ordering constraint with the previous node
                if (prev != null) {
                    if (level == 0 && prev >= current.val) {
                        return false;
                    }
                    if (level == 1 && prev <= current.val) {
                        return false;
                    }
                }

                // Update the previous node value to the current node value
                prev = current.val;

                // Add the left and right child nodes of the current node to the queue for processing
                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);

                // Decrement the count of nodes to be processed in the current level
                count --;
            }

            // Switch the level to the next level (even or odd)
            level = (level+1) % 2;
        }

        // If all nodes are processed without any violation, then the tree is an even-odd tree
        return true;
    }
}
