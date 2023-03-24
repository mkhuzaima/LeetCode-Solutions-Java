/*
 * 200. Number of Islands
 * Problem Link: https://leetcode.com/problems/number-of-islands/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class UnionFind {
    private int [] par;
    private  int setCount;

    public UnionFind(int n) {
        par = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = i;
        }

        setCount = 0;
    }

    public int find(int i) {
        if (par[i] == i) return i;
        return par[i] = find(par[i]);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            par[x] = y;
            setCount--;
        }
    }

    public int getSetCount() {
        return setCount;
    }

    public void incrementSetCount() {
        setCount++;
    }
}

class Solution {
    UnionFind uf;
    int rows;
    int cols;
    char [][] grid;

    public int numIslands(char[][] grid) {

        rows = grid.length;
        cols  = grid[0].length;
        uf = new UnionFind(rows * cols);
        this.grid = grid;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                
                if (grid[i][j] == '0') continue;

                uf.incrementSetCount();

                addIfValid(i, j, i-1, j);
                addIfValid(i, j, i, j-1);
                // addIfValid(uf, rows, cols, i, j, i+1, j);                
                // addIfValid(uf, rows, cols, i, j, i, j+1);
            }
        }

        return uf.getSetCount();
    }

    private void addIfValid(int x1, int y1, int x2, int y2) {

        if (x2 >= 0 && y2 >= 0 && grid[x2][y2] == '1') {
            uf.union(cols*x1+y1, cols*x2+y2);
        }
    }

}