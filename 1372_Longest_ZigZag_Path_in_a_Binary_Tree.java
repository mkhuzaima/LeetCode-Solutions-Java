// id: 1372
// Name: Longest ZigZag Path in a Binary Tree
// link: https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
// Difficulty: Medium

class Solution {
    int maxLength = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root.left, false, 1);
        dfs(root.right, true, 1);
        return maxLength;
    }

    private void dfs(TreeNode root, boolean toLeft, int sum) {
        if (root == null) {
            return;
        }


        maxLength = Math.max(maxLength, sum);
        if (toLeft) {
            dfs(root.left, false, sum +1);
            dfs(root.right, true, 1);
        }
        else {
            dfs(root.right, true, sum +1);
            dfs(root.left, false, 1);
        }
        
    }
}
