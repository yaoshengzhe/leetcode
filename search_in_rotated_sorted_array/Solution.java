public class Solution {
    public int search(int[] A, int target) {
        int start = 0;
        int end = A.length;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (target == A[mid]) {
                return mid;
            } else if (A[start] < A[mid]) {
                if (A[start] <= target && target < A[mid]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            } else {
                if (A[mid] < target && target <= A[end-1]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        return -1;
    }
}
