/*
 * 1466. Reorder Routes to Make All Paths Lead to the City Zero
 * Problem Link: https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    Map<Integer, List<int []>> map;

    int count = 0;
    public int minReorder(int n, int[][] connections) {
        // create graph of the problem
        map = new HashMap<>();

        for (int [] connection: connections) {
            map.computeIfAbsent(connection[0], k-> new ArrayList<>()).add(
                new int[]{connection[1], 1}    // original edge
            );
            
            map.computeIfAbsent(connection[1], k-> new ArrayList<>()).add(
                new int[]{connection[0], 0}    // artificial edge
            );
        }

        // dfs on node 0
        dfs(0, -1);

        return count;
    }

    private void dfs(int current, int parent) {
        // parent is used to avoid traversing parent again
        
        for (int [] neighbour: map.get(current)) {
            if (neighbour[0] != parent) {
                count += neighbour[1];
                dfs(neighbour[0], current);
            }
        }
    }
}
