// id: 744
// Name: Find Smallest Letter Greater Than Target
// link: https://leetcode.com/problems/find-smallest-letter-greater-than-target/
// Difficulty: Easy

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        int start = 0;
        int end = letters.length-1;
        int mid;

        while (start <= end) {
            mid = (start+end)/2;

            // should be greater than target
            if (letters[mid] <= target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        // start will be n if all elements are smaller.
        return letters[start % letters.length];
    }
}
