/*
 * 1011. Capacity To Ship Packages Within D Days
 * Problem Link: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n= weights.length;

        // find maximum weight, and sum of weights
        int sum = weights[0];
        int max = weights[0];
        for(int i = 1; i < n; i++) {
            sum += weights[i];
            if (weights[i] > max) max = weights[i];
        }


        int left = max;
        int right = sum;

        while (left < right){
            int mid = (left + right) / 2;

            if (isFeasible(weights, days, mid)) {
                // search if feasible with lower capcity
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isFeasible(int [] weights, int days, int capacity) {
        int currentLoad = 0;
        int requiredDays = 1;

        for (int weight: weights) {
            currentLoad += weight;
            if (currentLoad > capacity) {
                requiredDays++;
                currentLoad = weight;
                if (requiredDays > days) return false;
            }
        }

        return true;
    }
}
