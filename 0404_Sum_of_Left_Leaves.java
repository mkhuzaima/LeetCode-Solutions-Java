// id: 404
// Name: Sum of Left Leaves
// link: https://leetcode.com/problems/sum-of-left-leaves/
// Difficulty: Easy

class Solution {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        preorder(root, false);
        return sum;
    }

    private void preorder(TreeNode node, boolean isLeft) {
        if (node == null) return;
        if (isLeft && node.left == null && node.right == null) {
            sum += node.val;
        }

        preorder(node.left, true);
        preorder(node.right, false);
    }
}
