public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = 0;
        for (int i=0; i < A.length; ++i) {
            if (A[i] != elem) {
                A[len++] = A[i];
            }
        }
        return len;
    }
}