import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] num) {
        int i=num.length-2;
        for (; i > -1; --i) {
            if (num[i+1] > num[i]) {
                reverse(num, i+1, num.length-1);
                for (int j=i+1; j < num.length; ++j) {
                    if (num[i] < num[j]) {
                        swap(num, i, j);
                        break;
                    }
                }
                break;
            }
        }
        if (i == -1) {
            reverse(num, 0, num.length-1);
        }
    }

    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    private void reverse(int[] num, int start, int end) {
        while (start < end) {
            swap(num, start, end);
            start++;
            end--;
        }
    }
}
