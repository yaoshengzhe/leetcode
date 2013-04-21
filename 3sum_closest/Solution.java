import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        boolean inited = false;
        int closestSum = -1;
        for (int i=0; i < num.length; ++i) {
            int j = i+1;
            int k = num.length-1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                if (!inited) {
                    closestSum = sum;
                    inited = true;
                }
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    return target;
                }
                if (inited && Math.abs(target-sum) < Math.abs(target-closestSum)) {
                    closestSum = sum;
                }
            }
        }
        return closestSum;
    }
}