/*
 * 95. Unique Binary Search Trees II
 * Problem Link: https://leetcode.com/problems/unique-binary-search-trees-ii/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public List<TreeNode> generateTrees(int n) {
        // Calls the recursive helper function to generate subtrees from 1 to n
        return generateSubtrees(1, n);
    }

    private List<TreeNode> generateSubtrees(int low, int high) {
        // Initialize an empty result list
        List<TreeNode> result = new ArrayList<>();

        // If low is greater than high, the subtree is empty, so add null to the result list
        if (low > high) {
            result.add(null);
            return result;
        }

        // Generate all possible subtrees by iterating from low to high
        for (int i = low; i <= high; i++) {
            // Recursively generate all possible left subtrees
            List<TreeNode> leftList = generateSubtrees(low, i-1);

            // Recursively generate all possible right subtrees
            List<TreeNode> rightList = generateSubtrees(i+1, high);

            // Merge the left, current, and right subtrees to create new trees
            for (TreeNode left: leftList) {
                for (TreeNode right: rightList) {
                    // Create a new tree with current node i and left and right subtrees
                    result.add(new TreeNode(i, left, right));
                }
            }
        }
        return result;
    }
}