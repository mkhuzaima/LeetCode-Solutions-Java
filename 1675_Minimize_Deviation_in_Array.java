/*
 * 1675. Minimize Deviation in Array
 * Problem Link: https://leetcode.com/problems/minimize-deviation-in-array/
 * Difficulty:   Hard
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public int minimumDeviation(int[] nums) {
        // deviation = max- min;
        
        // increase min
        // decrease max


        // step1: increase min
        // odd increases. i.e, we will multiply it by 2. it then becomes even
        // even don't increase. 

        // step2: decrease max
        // we will now decrease the maximum. even element will become half.
        // if max is odd, it can't be decreased, we will stop there.


        // to find the max element in log n, we will use priority queue.

        int minimum = Integer.MAX_VALUE;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int n: nums) {
            if (n % 2 != 0) {
                n = 2*n;    // increse min
            }
            pq.add(n);

            // update minimum of numbers
            minimum = Math.min(n, minimum);
        }


        int minDeviation = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int max = pq.poll();
            minDeviation = Math.min(minDeviation, max-minimum);
            // if it is odd, it can't be decreased
            if (max % 2 != 0) {
                break;
            }
            max = max/2;
            pq.add(max);
            minimum = Math.min(minimum, max);
        }


        // calculate deviation and return
        return minDeviation;
    }
}
