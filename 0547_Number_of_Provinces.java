/*
 * 547. Number of Provinces
 * Problem Link: https://leetcode.com/problems/number-of-provinces/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

// Union Find Approach
class Solution {

    int [] p;
    
    public int find(int x) {
        if (p[x] == x) 
            return x;
        return p[x] = find(p[x]);
    }

    public boolean union (int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            p[x] = y;
            return true;
        }
        return false;
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        int count = n;

        p = new int [n];

        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++ ){
                if (isConnected[i][j] == 1) {
                    if (union(i, j))
                        count--;
                }
            }
        }
        return count;
    }
}
