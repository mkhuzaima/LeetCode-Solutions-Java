// id: 20
// Name: Valid Parentheses
// link: https://leetcode.com/problems/valid-parentheses/
// Difficulty: Easy

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
