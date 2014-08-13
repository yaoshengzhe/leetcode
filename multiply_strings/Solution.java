import java.lang.StringBuilder;

public class Solution {
    public String multiply(String num1, String num2) {
        int len = num1.length() + num2.length();
        int[] buf = new int[num1.length() + num2.length() + 1];
        for (int i=0; i < buf.length; ++i) {
            buf[i] = 0;
        }

        for (int i=num1.length()-1; i >= 0; --i) {
            int a = num1.charAt(i) - '0';
            for (int j=num2.length()-1; j >= 0; --j) {
                int b = num2.charAt(j) - '0';
                buf[len - i - j - 2] += a * b;
            }
        }

        int carry = 0;
        for (int i=0; i < buf.length - 1; ++i) {
            int val = buf[i] + carry;
            buf[i] = (val % 10);
            carry = (val / 10);
        }
        buf[num1.length() + num2.length()] = carry;

        StringBuilder builder = new StringBuilder();
        int i = buf.length - 1;
        while (i >= 0 && buf[i] == 0) {
            i--;
        }

        for (; i >= 0; --i) {
            builder.append(buf[i]);
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }
}
