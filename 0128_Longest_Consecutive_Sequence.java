/*
 * 128. Longest Consecutive Sequence
 * Problem Link: https://leetcode.com/problems/longest-consecutive-sequence/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

// Easier approach is by sorting the array
// This approach uses disjoint set union to find the longest consecutive sequence in the array.
class Solution {
    class UnionFind {
        int[] par;
        int[] size;

        int maxSize;

        public UnionFind(int n) {
            par = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                par[i] = i;
                size[i] = 1;
            }
            maxSize = (n == 0) ? 0 : 1;
        }

        int find(int x) {
            if (x == par[x])
                return x;
            return par[x] = find(par[x]);
        }

        boolean union(int x, int y) {

            x = find(x);
            y = find(y);

            if (x == y)
                return false;

            par[x] = y;
            size[y] += size[x];

            maxSize = Math.max(maxSize, size[y]);
            // union by size/rank can also be applied
            return true;
        }
    }

    public int longestConsecutive(int[] nums) {

        // using disjoint set union
        int n = nums.length;

        Map<Integer, Integer> valToIndex = new HashMap<>();
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            if (valToIndex.containsKey(nums[i]))
                continue;

            // join 2 sets if they are consecutive
            if (valToIndex.containsKey(nums[i] + 1)) {
                uf.union(i, valToIndex.get(nums[i] + 1));
            }
            if (valToIndex.containsKey(nums[i] - 1)) {
                uf.union(i, valToIndex.get(nums[i] - 1));
            }

            valToIndex.put(nums[i], i);
        }

        return uf.maxSize;
    }
}