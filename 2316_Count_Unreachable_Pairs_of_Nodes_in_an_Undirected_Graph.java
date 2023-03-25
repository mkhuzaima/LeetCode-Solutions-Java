// id: 2316
// Name: Count Unreachable Pairs of Nodes in an Undirected Graph
// link: https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
// Difficulty: Medium

class Solution {
    boolean [] visited;
    Map<Integer, List<Integer>> graph;

    public long countPairs(int n, int[][] edges) {

        // create a graph
        graph = new HashMap<>();

        for (int [] edge: edges) {
            graph.computeIfAbsent(edge[0], k->new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k->new ArrayList<>()).add(edge[0]);
        }

        long ans = 0;

        long remainingNodes = n;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            int componentSize = dfs(i);
            remainingNodes -= componentSize;

            ans += componentSize * remainingNodes;
        }
        return ans;
    }

    int dfs(int node) {
        if (visited[node]) return 0;

        visited[node] = true;

        // no neighbour
        if (!graph.containsKey(node)) return 1;

        int count = 1;
        for (int neighbour: graph.get(node)) {
            count += dfs(neighbour);
        }
        
        return count;
    }
}
