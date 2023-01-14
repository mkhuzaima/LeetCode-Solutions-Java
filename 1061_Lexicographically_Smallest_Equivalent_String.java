/*
 * 1061. Lexicographically Smallest Equivalent String
 * Problem Link: https://leetcode.com/problems/lexicographically-smallest-equivalent-string
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    int[] parent = new int[26];


    // returns the top most parent of x
    private int find(int x) {
        if (parent[x] == -1) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }


    private void union(int x, int y) {
        // find the top most parent of x and y
        // i.e., smallest value they will map to

        x = find(x);
        y = find(y);

        if (x==y) return;

        // now, if both are different, make parent[large]=small
        if (x > y) {
            parent[x] = y;
        }
        else {
            parent[y] = x;
        }
    }


    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        // parent will be smaller than child
        Arrays.fill(parent, -1);

        int n = s1.length();

        for (int i = 0; i < n; i++ ) {
            union(s1.charAt(i)-'a', s2.charAt(i)-'a');
        }


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < baseStr.length(); i++) {
            sb.append((char)(find(baseStr.charAt(i) - 'a') + 'a'));
        }

        return sb.toString();
    }
}