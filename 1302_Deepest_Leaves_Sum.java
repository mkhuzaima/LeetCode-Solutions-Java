// id: 1302
// Name: Deepest Leaves Sum
// link: https://leetcode.com/problems/deepest-leaves-sum/
// Difficulty: Medium

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        int sum = 0;
        while (!q.isEmpty()) {
            sum = 0;

            // for all nodes at this level
            for (int count = q.size(); count > 0; count--) {
                TreeNode n = q.poll();
                sum += n.val;

                // add children to queue (for next level)
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
        }
        return sum;
    }
}