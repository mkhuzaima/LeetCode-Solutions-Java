// id: 3
// Name: Longest Substring Without Repeating Characters
// link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Difficulty: Medium

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        Map<Character, Integer> lastOccurrence = new HashMap<>();

        int prev = 0;
        for (int current = 0; current < s.length(); current++) {
            // if last occurrence of current is before `prev`, then greater will be considered.

            // like abba
            // at index 3, last occurrence of a is 0, but 1 will be considered. 
          
            // there will be distinct characters from in [prev, current]
            prev = Math.max(lastOccurrence.getOrDefault(s.charAt(current), prev), prev);

            max = Math.max(current-prev+1, max);
            lastOccurrence.put(s.charAt(current), current+1);
        }
        return max;
    }
}
