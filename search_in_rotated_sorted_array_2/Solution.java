public class Solution {
    public boolean search(int[] A, int target) {
        return searchHelper(A, 0, A.length, target);
    }
    
    private boolean searchHelper(int[] A, int start, int end, int target) {
        if (start >= end) {
            return false;
        }
        int mid = start + (end - start) / 2;
        if (A[mid] == target) {
            return true;
        } else if (A[start] == A[end-1] || A[start] == A[mid]) {
            return searchHelper(A, start, mid, target) || searchHelper(A, mid+1, end, target);
        } else if (A[start] < A[mid]) {
            if (A[start] <= target && target <= A[mid]) {
                return searchHelper(A, start, mid, target);
            } else {
                return searchHelper(A, mid+1, end, target);                
            }
        } else {
            if (A[mid] <= target && target <= A[end-1]) {
                return searchHelper(A, mid+1, end, target);
            } else {
                return searchHelper(A, start, mid, target);                
            }
        }
    }
}