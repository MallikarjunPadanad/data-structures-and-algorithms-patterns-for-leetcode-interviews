/*
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.

Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 10^4
s consists of English letters, digits, symbols and spaces.
*/

/**
 * LongestSubstringWithoutRepeatingCharacters
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        boolean[] count = new boolean[256];
        int first = 0, second = 0, len = 0;
        while (second < n) {
            while (count[s.charAt(second)]) {
                count[s.charAt(first)] = false;
                first++;
            }

            count[s.charAt(second)] = true;
            len = Math.max(len, second - first + 1);
            second++;
        }
        return len;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String s = "abcabcbb";
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println("Length of longest substring without repeating characters: " + result);
    }
}
