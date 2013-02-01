/**
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/

public class Solution {
    public int reverse(int x) {
        int sgn = 1;
        if (x < 0) {
            x = -x;
            sgn = -1;
        }
        int result = 0;
        while (x > 0) {
            result = 10 * result + x % 10;
            x /= 10;
        }
        return sgn * result;
    }
}
