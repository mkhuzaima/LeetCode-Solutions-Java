/*
 * 20. Valid Parentheses
 * Problem Link: https://leetcode.com/problems/valid-parentheses/
 * Difficulty:   Easy
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            // if no matching bracket, then not valid
            else if (stack.isEmpty()) {
                return false;

            // check for matching bracket
            } else {
                char lastElement = stack.pop();

                if ((c == ']' && lastElement != '[') ||
                    (c == ')' && lastElement != '(') ||
                    (c == '}' && lastElement != '{') 
                   ){
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
        
    }
}
