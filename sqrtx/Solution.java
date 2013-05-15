public class Solution {
    public int sqrt(int x) {
        if (x <= 0) {
            return 0;
        } else if (x < 4) {
            return 1;
        }
        int start = 1;
        int end = x / 2 + 1;
        while (start < end) {
            int mid = start + (end - start)/2;
            long val = (long)mid*mid;
            if (val == x) {
                return mid;
            } else if (val > x) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return end - 1;
    }
}