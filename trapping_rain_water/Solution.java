public class Solution {
    public int trap(int[] A) {
        int area = 0;
        int hi = 0;
        for (int i=1; i < A.length; ++i) {
            if (A[i] > A[hi]) {
                hi = i;
            }
        }
        int prev = 0;
        for (int left=1; left < hi; ++left) {
            if (A[left] < A[prev]) {
                area += A[prev] - A[left];
            } else {
                prev = left;
            }
        }
        prev = A.length-1;
        for (int right=A.length-2; right > hi; --right) {
            if (A[right] < A[prev]) {
                area += A[prev] - A[right];
            } else {
                prev = right;
            }
        }
        return area;
    }
}
