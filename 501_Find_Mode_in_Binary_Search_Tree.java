// id: 501
// Name: Find Mode in Binary Search Tree
// link: https://leetcode.com/problems/find-mode-in-binary-search-tree/
// Difficulty: Easy

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

    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        dfs(root);

        // get max from node;
        int max = 0;
        int frequency = 0;
        for (int key: map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                frequency = 1;
            }
            else if (map.get(key) == max) {
                frequency++;
            }
        }

        // get all nodes with frequency = max
        int [] ans = new int[frequency];
        int i = 0;

        for (int key: map.keySet()) {
            if (map.get(key) == max) {
                ans[i++] = key; 
            }
        }


        return ans;
    }

    private void dfs(TreeNode node) {
        if (node== null) return;

        dfs(node.left);
        dfs(node.right);
        map.put(node.val, map.getOrDefault(node.val, 0)+1);
    }
}
