// id: 1921
// Name: Eliminate Maximum Number of Monsters
// link: https://leetcode.com/problems/eliminate-maximum-number-of-monsters/
// Difficulty: Medium

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double [] time = new double[n];

        for (int i = 0; i < n; i++) {
            time[i] = dist[i]*1.0 / speed[i];
        }

        Arrays.sort(time);

        int i = 0;
        while (i < n && time[i] > i) {
            i++;
        }
        return i;
    }
}
