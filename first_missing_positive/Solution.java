public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        for (int i=0; i < A.length; ) {
            int n = A[i];
            if (n >= 0 && n < A.length && A[n] != n) {
                swap(A, i, n);
            } else {
                i++;
            }
        }
        for (int i=1; i < A.length; ++i) {
            if (A[i] != i) {
                return i;
            }
        }
        return A[0] == A.length ? A.length + 1 : A.length;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
