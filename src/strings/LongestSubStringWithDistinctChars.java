package strings;

import java.util.HashSet;
import java.util.Set;
/*3. Longest Substring Without Repeating Characters
Input: "abcabcbb"
Output: 3
Input: "bbbbb"
Output: 1
Input: "pwwkew"
Output: 3
*/

public class LongestSubStringWithDistinctChars {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));


    }
    public static int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int maxCount=0;
        int n = s.length();
        Set<Character> st = new HashSet<>();
        while(i<n && j<n) {
            if(!st.contains(s.charAt(j))) {
                st.add(s.charAt(j));
                j++;
            }
            else {
                st.remove(s.charAt(i));
                i++;

            }
            maxCount = Math.max(maxCount,j-i);

        }
        return maxCount;

    }
}
