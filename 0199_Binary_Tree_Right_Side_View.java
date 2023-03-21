// id: 199
// Name: Binary Tree Right Side View
// link: https://leetcode.com/problems/binary-tree-right-side-view/
// Difficulty: Medium

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // right side view means the rightmost element of each level

        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }

        while (!q.isEmpty()) {
            int count = q.size();
            // traverse the complete level
            while (count > 0) {
                root = q.poll();

                if (root.left != null) {
                    q.add(root.left);
                }
                if (root.right != null) {
                    q.add(root.right);
                }
                count--;
            }
            // add the last level to the result
            result.add(root.val);
        }

        return result;
    }
}
