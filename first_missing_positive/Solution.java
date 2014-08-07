public class Solution {
    public int firstMissingPositive(int[] A) {
        for (int i=0; i < A.length;) {
            if (A[i] >= 1 && A[i] != (i+1) && A[i] - 1 < A.length && A[i] != A[A[i]-1]) {
                int tmp = A[i];
                A[i] = A[tmp - 1];
                A[tmp - 1] = tmp;
            } else {
                i++;
            }
        }
        for (int i=0; i < A.length; ++i) {
            if (A[i] != i+1) {
                return i+1;
            }
        }
        return A.length + 1;
    }
}
