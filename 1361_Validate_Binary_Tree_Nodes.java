// id: 1361
// Name: Validate Binary Tree Nodes
// link: https://leetcode.com/problems/validate-binary-tree-nodes/
// Difficulty: Medium

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean [] visited;
        // for improvement, find root and apply bfs on root node only.
        for (int root = 0; root < n; root++) {
            visited = new boolean[n];
            // perform traversal from this node
            // bfs
            Queue<Integer> q = new LinkedList<Integer>();
            q.offer(root);

            int visitedCount = 0;

            boolean flag = true; // false, if cycle
            while (!q.isEmpty()) {
                int e = q.poll();
                visitedCount++;

                if (visited[e]) {
                    flag = false;
                    break;
                }
                
                visited[e] = true;

                if (leftChild[e] != -1)  q.offer(leftChild[e]); 
                if (rightChild[e] != -1) q.offer(rightChild[e]);
            }
            // check if all are visited
            if (flag && visitedCount == n) {
                return true;
            }
        }
        return false;
    }
}
