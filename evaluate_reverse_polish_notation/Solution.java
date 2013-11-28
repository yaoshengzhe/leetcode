public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String ch : tokens) {
            if ("+".equals(ch)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(ch)) {
                int right = stack.pop();
                stack.push(stack.pop() - right);
            } else if ("*".equals(ch)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(ch)) {
                int right = stack.pop();
                stack.push(stack.pop() / right);
            } else {
                stack.push(Integer.parseInt(ch));
            }
        }
        return stack.get(0);
    }
}
