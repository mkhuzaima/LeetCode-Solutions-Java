// id: 205
// Name: Isomorphic Strings
// link: https://leetcode.com/problems/isomorphic-strings/description/
// Difficulty: Easy

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[128];

        boolean [] alreadyMapped = new boolean[128];

        for (int i = 0; i< s.length(); i++) {
            // considering 0 is not a valid value of character
            if (map[s.charAt(i)] == 0 && !alreadyMapped[t.charAt(i)]) {
                map[s.charAt(i)] = t.charAt(i);
                alreadyMapped[t.charAt(i)] = true;
            }
            else if (map[s.charAt(i)] != t.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
