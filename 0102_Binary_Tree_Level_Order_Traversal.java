/*
 * 102. Binary Tree Level Order Traversal
 * Problem Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        if (root != null) {
            q.add(root);
        }

        List<List<Integer>> result = new ArrayList<>();
        while (!q.isEmpty()){
            // number of nodes at this leveel
            int count = q.size();
            
            List<Integer> list = new ArrayList<>(q.size());

            while (count > 0) {
                root = q.poll();
                list.add(root.val);
                if (root.left != null) {
                    q.add(root.left);
                }
                if (root.right != null) {
                    q.add(root.right);
                }
                count--;
            }
            result.add(list);
        }
        return result;
    }
}
