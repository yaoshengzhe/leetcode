import java.lang.Math;

public class Solution {
    public int maxSubArray(int[] A) {
        int maxSofar = Integer.MIN_VALUE;
        int maxEndHere = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int i : A) {
            maxEndHere = Math.max(0, maxEndHere + i);
            maxSofar = Math.max(maxSofar, maxEndHere);
            maxNum = Math.max(maxNum, i);
        }
        return maxNum > 0 ? maxSofar : maxNum;
    }
}