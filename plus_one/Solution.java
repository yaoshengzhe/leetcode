
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i=digits.length-1; i > -1; --i) {
            if (carry == 0) {
                break;
            }
            int val = digits[i] + carry;
            digits[i] = val % 10;
            carry = val / 10;
        }
        if (carry == 1) {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            for (int i=1; i < result.length; ++i) {
                result[i] = digits[i-1];
            }
            return result;
        } else {
            return digits;
        }
    }
}