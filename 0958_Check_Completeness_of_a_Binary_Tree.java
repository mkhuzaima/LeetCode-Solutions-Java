// id: 958
// Name: Check Completeness of a Binary Tree
// link: https://leetcode.com/problems/check-completeness-of-a-binary-tree/
// Difficulty: Medium

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);

        boolean nullNodeFound = false;


        while (!q.isEmpty()) {
            TreeNode n = q.poll();

            if (n == null) {
                // all next nodes should be null
                nullNodeFound = true;
            }
            else {
                if (nullNodeFound) {
                    return false;
                }
                q.add(n.left);
                q.add(n.right);
            }
        }

        return true;
    }
}