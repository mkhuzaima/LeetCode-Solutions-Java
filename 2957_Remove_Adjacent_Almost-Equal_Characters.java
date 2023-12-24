// id: 2957
// Name: Remove Adjacent Almost-Equal Characters
// link: https://leetcode.com/problems/remove-adjacent-almost-equal-characters
// Difficulty: Medium

class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int count = 0;
        for (int i = 1; i < word.length(); i++) {
            if (Math.abs(word.charAt(i) - word.charAt(i-1)) <= 1) {
                i++;
                count++;
            }
        }

        return count;
    }
}
