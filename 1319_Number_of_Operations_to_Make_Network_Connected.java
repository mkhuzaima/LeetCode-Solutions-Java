// id: 1319
// Name: Number of Operations to Make Network Connected
// link: https://leetcode.com/problems/number-of-operations-to-make-network-connected/
// Difficulty: Medium

class UnionFind {
    int [] par;

    int setCount = 0;

    UnionFind(int n) {
        par = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = i;
        }

        setCount = n;
    }

    int find(int x) {
        if (par[x] == x) return x;

        return par[x] = find(par[x]);
    }

    void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            par[x] =y;
            setCount--;
        }
    }

}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        // to connect n computers we need n-1 cables;
        if (connections.length < n-1) {
            return -1;
        }

        UnionFind uf = new UnionFind(n);


        for (int [] connection: connections) {
            uf.union(connection[0], connection[1]);
        }

        // number of operations will be equal to setCount -1 ;
        // if 1 set, 0 operations, etc...
        return uf.setCount - 1;
    }
}
