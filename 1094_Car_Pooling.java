/*
 * 1094. Car Pooling
 * Problem Link: https://leetcode.com/problems/car-pooling/
 * Difficulty:   Medium
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, ( a, b) -> a[1] - b[1]);

        int currentPassengerCount = 0;

        int distance = 0;

        // min heap (pair = to, numPassengers)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        
        // add capacity passengers. 
        for (int[] trip: trips) {
            int numPassengers = trip[0];

            // System.out.println("disctance is " + distance);

            // we have travelled till start distance;
            distance = trip[1];

            while (!pq.isEmpty() && pq.peek()[2] <= distance){
                // System.out.println("peek is " + Arrays.toString(pq.peek()));
                currentPassengerCount -= pq.peek()[0];
                pq.remove();
            }


            if ((numPassengers + currentPassengerCount) > capacity) {
                return false;
            }

            pq.add( trip );
            currentPassengerCount += numPassengers;
        }

        return true;
    }
}
