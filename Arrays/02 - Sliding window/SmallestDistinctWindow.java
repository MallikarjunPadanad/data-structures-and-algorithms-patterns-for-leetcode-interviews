/*
link : https://www.geeksforgeeks.org/problems/smallest-distant-window3132/1
Given a string str, your task is to find the length of the smallest window that contains all the characters of the given string at least once.
Example:
Input: str = "aabcbcdbca"
Output: 4
Explanation: Sub-String "dbca" has the smallest length that contains all the characters of str.


Input: str = "aaab"
Output: 2
Explanation: Sub-String "ab" has the smallest length that contains all the characters of str.

Input: str = "geeksforgeeks"
Output: 7
Explanation: There are multiple substring with smallest length that contains all characters of str, "eksforg" and "ksforge". 


Constraints:
1 ≤ str.size() ≤ 10^5
str contains only lower-case english alphabets. 
*/

public class SmallestDistinctWindow {
    public int findSubString(String str) {
        // code here
        int[] count = new int[256];
        int first = 0, second = 0, len = str.length(), diff = 0;

        while (first < str.length()) {
            if (count[str.charAt(first)] == 0) {
                diff++;
            }
            count[str.charAt(first)]++;
            first++;
        }
        for (int i = 0; i < 256; i++) {
            count[i] = 0;
        }

        first = 0;
        while (second < str.length()) {

            while (diff != 0 && second < str.length()) {
                if (count[str.charAt(second)] == 0) {
                    diff--;
                }
                count[str.charAt(second)]++;
                second++;
            }

            len = Math.min(len, second - first);

            while (diff != 1) {
                len = Math.min(len, second - first);
                count[str.charAt(first)]--;
                if (count[str.charAt(first)] == 0) {
                    diff++;
                }
                first++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        SmallestDistinctWindow solution = new SmallestDistinctWindow();

        String str = "aabcbcdbca";

        System.out.println("Input  : " + str);
        System.out.println("Output : " + solution.findSubString(str));
    }
}