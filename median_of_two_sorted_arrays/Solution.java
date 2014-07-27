public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {

        int len = A.length + B.length;
        if (len % 2 == 0) {
            return (double)(findKSortedArrays(A, 0, A.length, B, 0, B.length, len / 2) +
                            findKSortedArrays(A, 0, A.length, B, 0, B.length, len / 2 - 1)) / 2;
        } else {
            return findKSortedArrays(A, 0, A.length, B, 0, B.length, len / 2);
        }
    }

    private int findKSortedArrays(int A[], int a, int b, int B[], int x, int y, int k) {
        if (a >= b) {
            return B[x + k];
        } else if (x >= y) {
            return A[a + k];
        }

        int midA = a + (b - a) / 2;
        int midB = x + (y - x) / 2;

        if ( midA - a + midB - x >= k) {
            if (A[midA] >= B[midB]) {
                return findKSortedArrays(A, a, midA, B, x, y, k);
            } else {
                return findKSortedArrays(A, a, b, B, x, midB, k);
            }
        } else {
            if (A[midA] >= B[midB]) {
                return findKSortedArrays(A, a, b, B, midB + 1, y, k - (midB - x + 1));
            } else {
                return findKSortedArrays(A, midA + 1, b, B, x, y, k - (midA - a + 1));
            }
        }
    }
}
