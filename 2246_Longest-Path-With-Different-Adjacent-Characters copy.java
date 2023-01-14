// id: 2246
// Name: Longest Path With Different Adjacent Characters
// link: https://leetcode.com/problems/longest-path-with-different-adjacent-characters/
// Difficulty: Hard

class Solution {

    int longestPath = 1;
    
    private int dfs(int currentNode, String s, List<Integer>[] graph) {

        int max = 0;        // longest chain from children
        int secondMax = 0;  // second longest chain from children

        for (int child: graph[currentNode]) {

            int subTreePath = dfs(child, s, graph);
            
            // only update path if characters are different
            if (s.charAt(child) != s.charAt(currentNode)) {
                // max, secondMax
                if (subTreePath > max) {
                    secondMax = max;
                    max = subTreePath;
                }
                else if (subTreePath > secondMax) {
                    secondMax = subTreePath;
                }
            }
                 
        }


        // node can connect with 2 nodes, 
        // either both will be child 
        // or 1 child and 1 parent
        longestPath = Math.max(longestPath, 1 + max + secondMax);

        return 1 + max; // if connects with parent
    }

    public int longestPath(int[] parents, String s) {

        int n = parents.length;

        // create a graph using adjacency list
        List<Integer>[] graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            graph[parents[i]].add(i);
        }

        dfs(0, s, graph);

        return longestPath;
    }

}