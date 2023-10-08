// id: 1457
// Name: Pseudo-Palindromic Paths in a Binary Tree
// link: https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
// Difficulty: Medium

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
    boolean[] occursOddTimes = new boolean[10];
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root);
        return count;
    }

    private void dfs(TreeNode root) {

        // leaf node
        occursOddTimes[root.val] = !occursOddTimes[root.val];

        if (root.left == null && root.right == null) {

            // odd should occur only 1 time for it to be palindromic
            
            occursOddTime.stream().count
            int oddCount = 0;

            for (boolean f: occursOddTimes) {
                if (f) oddCount++;
            }
            if (oddCount <= 1) count++;

        }
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }

        // remove this node from array
        occursOddTimes[root.val] = !occursOddTimes[root.val];
    }
}
