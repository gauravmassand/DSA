package stacks;
/*
1047. Remove All Adjacent Duplicates In String
Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.



Example 1:

Input: "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal,
and this is the only possible move.  The result of this move is that the string is "aaca",
of which only "aa" is possible, so the final string is "ca".
 */

import java.util.Stack;

public class RemoveAdjacentDupCharacter {

    public static void main(String[] args) {
        removeDuplicates("abbaca");
    }

    public static String removeDuplicates(String S) {
        Stack<Character> charStack = new Stack<>();
        for(int i=0;i<S.length();i++) {

            if(charStack.isEmpty()) {
                charStack.push(S.charAt(i));
            }
            else {
                if(charStack.peek()==S.charAt(i)) {
                    charStack.pop();
                }
                else {
                    charStack.push(S.charAt(i));
                }
            }
        }
        StringBuilder output=new StringBuilder("");
        for(Character ipchar : charStack) {
            output.append(ipchar);
        }
        return output.toString();


    }

}
