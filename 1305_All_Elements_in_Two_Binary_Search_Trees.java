/*
 * 1305. All Elements in Two Binary Search Trees
 * Problem Link: https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        inOrder(list, root1, 0);
        inOrder(list, root2, 0);
        
        return list;

    }
    private void inOrder(List<Integer> list, TreeNode node, int index) {
        if (node == null) return;
        
        inOrder(list, node.left, index);

        while (index < list.size() && list.get(index) < node.val) {
            index++;
        }
        list.add(index, node.val);

        inOrder(list, node.right, index+1);
    }

}
