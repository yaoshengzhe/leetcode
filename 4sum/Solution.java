import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for (int i=0; i < num.length;) {
            for (int j=i+1; j < num.length;) {
                int k = j+1;
                int m = num.length-1;
                
                while (k < m) {
                    int sum = num[i] + num[j] + num[k] + num[m];
                    if (sum > target) {
                        m = jumpToPrev(num, m);
                    } else if (sum < target) {
                        k = jumpToNext(num, k);
                    } else {
                        result.add(new ArrayList<Integer>(Arrays.asList(num[i], num[j], num[k], num[m])));
                        k = jumpToNext(num, k);
                        m = jumpToPrev(num, m);    
                    }
                }
                j = jumpToNext(num, j);
            }
            i = jumpToNext(num, i);
        }
        return result;
    }
    
    private int jumpToNext(int[] num, int i) {
        int val = num[i];
        while (i < num.length && num[i] == val) {
            i++;
        }
        return i;
    }
    
    private int jumpToPrev(int[] num, int i) {
        int val = num[i];
        while (i > -1 && num[i] == val) {
            i--;
        }
        return i;
    }
    
}