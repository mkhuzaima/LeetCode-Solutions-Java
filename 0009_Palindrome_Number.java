// id: 9
// Name: Palindrome Number
// link: https://leetcode.com/problems/palindrome-number/
// Difficulty: Easy

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reverted = 0;
        while (x > reverted) {
            reverted = 10*reverted + x%10;
            x /= 10;
        }


        return x == reverted || x == reverted / 10;
    }
}
