package stacks;
/*
We are given that the string "abc" is valid.

From any valid string V, we may split V into two pieces X and Y such that X + Y (X concatenated with Y) is equal to V.  (X or Y may be empty.)  Then, X + "abc" + Y is also valid.

If for example S = "abc", then examples of valid strings are: "abc", "aabcbc", "abcabc", "abcabcababcc".  Examples of invalid strings are: "abccba", "ab", "cababc", "bac".

Return true if and only if the given string S is valid.
 */

import java.util.Stack;

public class checkValidSubstitution {
    public static void main(String[] args) {
        System.out.println(isValid("aabbcc"));

    }

    public static boolean isValid(String S) {
        Stack<Character> charStack = new Stack<>();
        for (int i=0;i<S.length();i++) {
            Character c = S.charAt(i);
            if(c!='c') {
                charStack.push(c);
            } else {
                if(charStack.size()>=2) {
                    char char1 = charStack.pop();
                    char char2 = charStack.pop();
                    if(char1!='b' && char2!='a') {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }
        return charStack.isEmpty() ? true : false;

    }
}
