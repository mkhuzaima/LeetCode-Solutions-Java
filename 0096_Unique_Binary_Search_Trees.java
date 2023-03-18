/*
 * 96. Unique Binary Search Trees
 * Problem Link: https://leetcode.com/problems/unique-binary-search-trees/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int numTrees(int n) {

        // dynamic programming, memoization
        int [] numUniqueBST = new int[n+1];

        // 1 unique BST for size 0 and 1
        numUniqueBST[0] = numUniqueBST[1] = 1;

        // calcualte number of unique BSTs for size upto n (0 and 1 already calcualted)
        for (int i = 2; i <= n; i++) {
            numUniqueBST[i] = 0;

            for (int j = 1; j <= i; j++) {
                // choose j as root
                // size of left tree is j-1
                // size of rigth subtree is i-j
                numUniqueBST[i] += numUniqueBST[j-1] * numUniqueBST[i-j];
            }
        }

        return numUniqueBST[n];
    }
}
