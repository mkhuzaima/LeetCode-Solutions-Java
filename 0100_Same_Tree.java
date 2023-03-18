// id: 100
// Name: Same Tree
// link: https://leetcode.com/problems/same-tree/
// Difficulty: Easy

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // if both are same (null)
        if (p == q) return true;

        // both are different
        // if only 1 is null
        if (p == null || q == null) return false;

        // self explanatory
        return (p.val == q.val) &&
                    isSameTree(p.left, q.left) &&  
                    isSameTree(p.right, q.right);
    }
}
