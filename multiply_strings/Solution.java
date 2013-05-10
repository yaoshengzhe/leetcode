import java.lang.StringBuilder;

public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() > num2.length()) {
            return multiply(num2, num1);
        }
        String result = "0";
        int sgn = 1;
        if (num1.charAt(0) == '-') {
            sgn = -sgn;
            num1 = num1.substring(1);
        }
        if (num2.charAt(0) == '-') {
            sgn = -sgn;
            num2 = num2.substring(1);
        }

        for (int i=num1.length()-1; i > -1 ; --i) {
            int carry = 0;
            StringBuilder buf = new StringBuilder();
			for (int k = i+1; k < num1.length(); ++k) {
				buf.append('0');
			}
            int a = num1.charAt(i) - '0';
			if (a != 0) {
            	for (int j=num2.length()-1; j > -1 ; --j) {
                	int b = num2.charAt(j) - '0';
                	int val = a * b + carry;
                	buf.append(val % 10);
                	carry = val / 10;
            	}
            	if (carry > 0) {
                	buf.append(carry);
            	}
            	buf.reverse();
				result = add(buf.toString(), result);
			}
        }
        return sgn < 0 ? "-" + result : result;
    }

    private String add(String s1, String s2) {
        StringBuilder buf = new StringBuilder();
        int carry = 0;
		int i = s1.length() - 1;
		int j = s2.length() - 1;
        while (i > -1 && j > -1) {
			int a = s1.charAt(i) - '0';
            int b = s2.charAt(j) - '0';
            int val = a + b + carry;
            buf.append(val % 10);
            carry = val / 10;
			i--;
			j--;
        }
		while (i > -1) {
			int a = s1.charAt(i) - '0';
            int val = a + carry;
            buf.append(val % 10);
            carry = val / 10;
			i--;			
		}
		while (j > -1) {
			int b = s2.charAt(j) - '0';
            int val = b + carry;
            buf.append(val % 10);
            carry = val / 10;
			j--;			
		}
        if (carry > 0) {
            buf.append(carry);
        }
        buf.reverse();
        return buf.toString();
    }
}
