// id: 2405
// Name: Optimal Partition of String
// link: https://leetcode.com/problems/optimal-partition-of-string/description/
// Difficulty: Medium

class Solution {
    public int partitionString(String s) {
        
        // create a set
        Set<Character> uniqueLetters = new HashSet<>();

        int min = 1;    // string length will be at least 1

        for (int i = 0; i < s.length(); i++ ) {
            if ( !uniqueLetters.add(s.charAt(i)) ) {
                uniqueLetters.clear();
                uniqueLetters.add(s.charAt(i));
                min++;
            }
        }

        return min;
    }
}
