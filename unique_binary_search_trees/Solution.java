public class Solution {
    // T(n) = \sum_0^(n-1) T(k) \dot T(n-k)
    public int numTrees(int n) {
        if (n < 0) {
            return 0;
        } else if (n < 2) {
            return 1;
        }

        int[] count = new int[n+1];
        count[0] = count[1] = 1;
        for (int i=2; i <= n; ++i) {
            for (int k=0; k <= i-1; ++k) {
                count[i] += count[k] * count[i-k-1];
            }
        }
        return count[n];
    }
}
