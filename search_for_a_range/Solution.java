import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int index = Arrays.binarySearch(A, 0, A.length, target);
        if (index < 0) {
            return new int[] {-1, -1};
        }
        return new int[] {findLower(A, target, 0, index), findUpper(A, target, index+1, A.length)};
    }

    // precondition, A[end] == target is true
    private int findLower(int[] A, int target, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    // precondition A[start-1] == target is true
    private int findUpper(int[] A, int target, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start - 1;
    }
}
