public class Solution {
    public int searchInsert(int[] A, int target) {
        int start = 0;
        int end = A.length;
        while (start < end) {
            int mid = start + (end - start)/2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}