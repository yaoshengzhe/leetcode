public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int cur = m+n-1;
        int i = m-1;
        int j = n-1;
        while (i >= 0 && j >= 0) {
            if (A[i] < B[j]) {
                A[cur--] = B[j--];
            } else {
                A[cur--] = A[i--];
            }
        }
        while (i >= 0) {
            A[cur--] = A[i--];
        }
        while (j >= 0) {
            A[cur--] = B[j--];
        }
    }
}