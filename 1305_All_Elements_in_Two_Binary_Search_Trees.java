// id: 1305
// Name: All Elements in Two Binary Search Trees
// link: https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
// Difficulty: Medium

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
