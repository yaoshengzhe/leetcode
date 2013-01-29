/**
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class Solution {
    private boolean isChar(char ch) {
        return (ch >= 'A' && ch <= 'Z')
            || (ch >= 'a' && ch <= 'z')
            || (ch >= '0' && ch <= '9');
    }

    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int i = 0;
        int j = str.length() - 1;
        boolean result = true;
        while (i < j) {
            if (!isChar(str.charAt(i))) {
                ++i;
            } else if (!isChar(str.charAt(j))) {
                --j;
            } else {
                if (str.charAt(i) != str.charAt(j)) {
                    result = false;
                    break;
                } else {
                    ++i;
                    --j;
                }
            }
        }
        return result;
    }
}
