// id: 1160
// Name: Find Words That Can Be Formed by Characters
// link: https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
// Difficulty: Easy

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
