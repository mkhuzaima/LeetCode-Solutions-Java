/*
 * 103. Binary Tree Zigzag Level Order Traversal
 * Problem Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        traverse(root, list, 0, false);

        return list;
    }
    private void traverse(TreeNode root, List<List<Integer>> list, int level, boolean toAddAtStart) {
        if (root == null) return;

        if (list.size() <= level) {
            list.add(new ArrayList<>());
        }
        if (toAddAtStart) {
            list.get(level).add(0, root.val);
        }
        else {
            list.get(level).add(root.val);
        }
        traverse(root.left, list, level+1, !toAddAtStart);
        traverse(root.right, list, level+1, !toAddAtStart);
    }
}
