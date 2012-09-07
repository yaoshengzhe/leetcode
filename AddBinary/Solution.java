import java.lang.StringBuilder;

public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }

        StringBuilder builder = new StringBuilder();
        int carry = 0;

        for (int i=0; i < b.length(); ++i) {
            int x = a.charAt(a.length() - i - 1) - '0';
            int y = b.charAt(b.length() - i - 1) - '0';
            builder.append( ( (x ^ y ^ carry) == 1) ? '1' : '0');
            carry = (x & y) | (y & carry) | (x & carry);
        }

        for (int i=b.length(); i < a.length() ; ++i) {
            int x = a.charAt(a.length() - i - 1) - '0';
            builder.append( ( (x ^ carry) == 1) ? '1' : '0');
            carry &= x;
        }
        if (carry > 0) {
            builder.append('1');
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("1110000100", "0"));
    }
}