// id: 102
// Name: Binary Tree Level Order Traversal
// link: https://leetcode.com/problems/binary-tree-level-order-traversal/
// Difficulty: Medium

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
