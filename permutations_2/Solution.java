import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
         do {
             ArrayList<Integer> data = new ArrayList<Integer>();
             for (int n : num) {
                 data.add(n);
             }
             result.add(data);
         } while (nextPermutation(num));
        return result;
    }

    private boolean nextPermutation(int[] num) {
        int len = num.length;
        for (int i=len-2; i > -1; --i) {
            if (num[i] < num[i+1]) {
                reverse(num, i+1, len-1);
                swap(num, i, bsearch(num, i+1, len, num[i]));
                return true;
            }
        }
        return false;
    }

    private int bsearch(int[] num, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] <= target) {
                start = mid + 1;
            } else if (num[mid] > target) {
                end = mid;
            }
        }
        return start;
    }

    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    private void reverse(int[] num, int i, int j) {
        while (i < j) {
            swap(num, i++, j--);
        }
    }
}
