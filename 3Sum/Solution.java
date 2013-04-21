import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        for (int i=0; i < len;) {
            int j = i+1;
            int k = len-1;
            while (j < k) {
                int sum2 = num[i] + num[j];
                if (sum2 + num[k] < 0) {
                    j++;
                } else if (sum2 + num[k] > 0) {
                    k--;
                } else {
                    result.add(new ArrayList<Integer>(Arrays.asList(num[i], num[j], num[k])));
                    int b = num[j];
                    while (j < len && num[j] == b) {
                        j++;
                    }
                    int c = num[k];
                    while (k > 0 && num[k] == c) {
                        k--;
                    }
                }
            }
            int a = num[i];
            while (i < len && num[i] == a) {
                i++;
            }
        }
        return result;
    }
}