// id: 653
// Name: Two Sum IV - Input is a BST
// link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
// Difficulty: Easy

class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        
        if (root == null) return false;

        if (set.contains(k - root.val)) {
            return true;
        } 

        set.add(root.val);

        return findTarget(root.left, k) || findTarget(root.right, k);
    }   
}
