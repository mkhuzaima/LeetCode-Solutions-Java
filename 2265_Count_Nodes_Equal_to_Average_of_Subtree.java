/*
 * 2265. Count Nodes Equal to Average of Subtree
 * Problem Link: https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
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
    int count = 0;

    int [] tuple = new int[3]; // match in tree, count in tree, sum of node values

    public int averageOfSubtree(TreeNode root) {
        // count nodes having value = average;
        return countNodes(root)[0];
    }

    private int[] countNodes(TreeNode root) {
        if (root == null) return new int[]{0, 0, 0};

        int[] left = countNodes(root.left);
        int[] right = countNodes(root.right);

        int [] result = new int[]{left[0]+right[0], left[1]+right[1]+1, left[2]+right[2]+root.val};

        int average = result[2]/result[1];

        if (root.val == average) {
            result[0]++;
        }
        return result;
    }

}
