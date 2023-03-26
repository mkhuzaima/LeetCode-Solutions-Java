// id: 2360
// Name: Longest Cycle in a Graph
// link: https://leetcode.com/problems/longest-cycle-in-a-graph/
// Difficulty: Hard

class Solution {
    int answer = -1;
    int count = 1;
    int [] dist;
    
    private void dfs(int node, int [] edges, int cycleStart) {
        // mark node as visited
        dist[node] = count++;
        
        int neighbour = edges[node];

        if (neighbour== -1) return;

        // if not visited, then visit
        if (dist[neighbour] == 0) {
            dfs(neighbour, edges, cycleStart);
        }
        // if visited in thsi cycle, then it is cycle
        else if (dist[neighbour] >= cycleStart) {
            answer = Math.max(answer, dist[node] - dist[neighbour] + 1);
        }
    }

    public int longestCycle(int[] edges) {
        dist = new int[edges.length];

        for (int i = 0; i < edges.length; i++) {
            // if not visited, then dfs
            if (dist[i] == 0)
                dfs(i, edges, count);
        }
        return answer;
    }
}
