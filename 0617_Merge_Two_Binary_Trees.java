// id: 617
// Name: Merge Two Binary Trees
// link: https://leetcode.com/problems/merge-two-binary-trees/
// Difficulty: Easy

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null ) return root2;
        if (root2 == null) return root1;
        return new TreeNode(root1.val + root2.val, 
                mergeTrees(root1.left, root2.left),
                mergeTrees(root1.right, root2.right)
            );
    }
}
