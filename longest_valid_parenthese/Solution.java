import java.util.Stack;
import java.lang.Math;

public class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i=0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
                maxLen = Math.max(maxLen, stack.isEmpty() ? (i+1) : (i - stack.peek()));
            }
        }
        return maxLen;
    }
}
