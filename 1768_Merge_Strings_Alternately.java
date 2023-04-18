// id: 1768
// Name: Merge Strings Alternately
// link: https://leetcode.com/problems/merge-strings-alternately/description/
// Difficulty: Easy

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 0;
        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        // append remaining of word1
        while (i < word1.length() ) {
            sb.append(word1.charAt(i++));
        }
        // append remaining of word2
        while (j < word2.length()) {
            sb.append(word2.charAt(j++));
        }

        return sb.toString();
    }
}