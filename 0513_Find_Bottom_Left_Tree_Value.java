// id: 513
// Name: Find Bottom Left Tree Value
// link: https://leetcode.com/problems/find-bottom-left-tree-value/
// Difficulty: Medium

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        if (root != null) {
            q.add(root);
        }

        int leftMost = 0;

        while (!q.isEmpty()) {
            int count = q.size();
            leftMost = q.peek().val;

            while (count > 0) {
                root = q.poll();
                if (root.left != null) q.add(root.left);
                if (root.right != null) q.add(root.right);
                count--;
            }
        }
        return leftMost;
    }
}
