public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        char[] buf = new char[n+n];
        generateParenthesisHelper(n, 0, 0, result, buf);
        return result;
    }

    private void generateParenthesisHelper(int n, int numOfLeft, int numOfRight, ArrayList<String> result, char[] buf) {
        if (numOfLeft == n && numOfLeft == numOfRight) {
            result.add(new String(buf));
            return;
        }

        if (numOfLeft < n) {
            buf[numOfLeft+numOfRight] = '(';
            generateParenthesisHelper(n, numOfLeft+1, numOfRight, result, buf);
        }

        if (numOfRight < numOfLeft) {
            buf[numOfLeft+numOfRight] = ')';
            generateParenthesisHelper(n, numOfLeft, numOfRight+1, result, buf);
        }
    }
}
