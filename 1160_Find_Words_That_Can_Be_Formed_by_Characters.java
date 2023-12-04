/*
 * 1160. Find Words That Can Be Formed by Characters
 * Problem Link: https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 * Difficulty:   Easy
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    int [] map = new int[26];
    int [] wordMap;
    public int countCharacters(String[] words, String chars) {
        for (int i = 0; i < chars.length(); i++) {
            map[chars.charAt(i)-'a']++;
        }

        int result = 0;
        for (String word: words) {
            if (matches(word)) {
                result += word.length();
            }
        }


        return result;
    }

    private boolean matches (String word) {
        wordMap = new int[26];

        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            wordMap[c]++;
            if (wordMap[c]>map[c]) return false;
        }

        return true;
    }
}
