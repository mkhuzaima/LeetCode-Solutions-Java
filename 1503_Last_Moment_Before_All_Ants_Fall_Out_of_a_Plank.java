// id: 1503
// Name: Last Moment Before All Ants Fall Out of a Plank
// link: https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
// Difficulty: Medium

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        // calcualte time taken by each ant to move to edge
        
        // store largest
        int result = 0;

        for (int l: left) {
            if (l > result) result = l;
        }

        for (int r: right) {
            if (n-r > result) result = n-r;
        }

        return result;
    }
}
