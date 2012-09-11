/**
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 

*/

public class Solution {
    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        } else if (n < 3) {
            return n;
        } else {
            int a = 1;
            int b = 1;
            int result = 2;
            for (int i=1; i < n; ++i) {
                result = a + b;
                a = b;
                b = result;
            }
            return result;
        }
    }
}