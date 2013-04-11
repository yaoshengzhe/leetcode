public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int len = 0;
        int num = x;
        while (num > 0) {
            len++;
            num /= 10;
        }
        
        while (x > 0) {
            if (len == 1) {
                return true;
            }
        
            int highest = x / pow10(len-1);
            int lowest = x % 10;
            if (highest != lowest) {
                return false;
            } else {
                x -= highest * pow10(len -1);
                x /= 10;
                len -= 2;
            }
        }
        return true;
    }
    
    private int pow10(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            int val = pow10(n/2);
            return val * val;
        } else {
            int val = pow10(n/2);
            return val * val * 10;
        }
    }
}