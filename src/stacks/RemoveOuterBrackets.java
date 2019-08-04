package stacks;
/*
A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.

A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.

Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.



Example 1:

Input: "(()())(())"
Output: "()()()"
Explanation:
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
Example 2:

Input: "(()())(())(()(()))"
Output: "()()()()(())"
Explanation:
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
Example 3:

Input: "()()"
Output: ""
Explanation:
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".
 */

import java.util.Stack;

public class RemoveOuterBrackets {


    public static void main(String[] args) {
        removeOuterParentheses("(()())(())");
    }

    public static String removeOuterParentheses(String S) {
        int openCount=0;
        int closeCount=0;
        int openBracketIndex=0;
        StringBuilder finalString = new StringBuilder("");
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<S.length();i++) {
            char c = S.charAt(i);
            if(c=='(') {
                openCount++;
            } else if(c==')') {
                closeCount++;
            }
            if(openCount==1) {
                openBracketIndex=0;
            }
            if(openCount == closeCount) {
                sb.deleteCharAt(openBracketIndex);
                openCount=0;
                closeCount=0;
                finalString.append(sb);
                sb.setLength(0);
            }
            else {
                sb.append(c);
            }

        }
        return finalString.toString();

    }


}
