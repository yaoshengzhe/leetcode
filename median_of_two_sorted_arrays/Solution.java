public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int targetIndex = (A.length + B.length) / 2;
        TwoSortedArrayIterator itr = new TwoSortedArrayIterator();
        double current = -1;
        while (targetIndex > 0) {
            current = itr.next(A, B);
            --targetIndex;
        }
        if ((A.length + B.length) % 2 == 1) {
            return itr.next(A, B);
        } else {
            return (current + itr.next(A, B)) / 2;
        }
    }
    
    private static class TwoSortedArrayIterator {
        int pa= 0;
        int pb = 0;
    public double next(int A[], int B[]) {
        if (pa < A.length && pb < B.length) {
                if (A[pa] < B[pb]) {
                    return A[pa++];
                } else {
                    return B[pb++];
                }
            }
        if (pa < A.length) {
                return A[pa++];
            } else if (pb < B.length) {
                return B[pb++];
            }
        return -1;
    }
    }
}