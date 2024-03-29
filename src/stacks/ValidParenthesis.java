package stacks;
/*
20. Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true

*/

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(isValid("([)]"));

    }

    public static boolean isValid(String s) {
        if(s==null) {
            return true;
        }
        if(s.length()==1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++) {
            Character c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{') {
                stack.push(c);
            }
            else
            {
                if(stack.isEmpty()) {
                    return false;
                }
                Character stackTop = stack.peek();
                Character validCharacter=null;
                if(c=='}')
                    validCharacter='{';
                if(c==']')
                    validCharacter='[';
                if(c==')')
                    validCharacter='(';
                if(stackTop != validCharacter) {
                    return false;
                }
                else {
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        }
        else return false;

    }
}
