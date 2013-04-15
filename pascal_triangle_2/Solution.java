import java.lang.Math;

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (rowIndex > -1) {
            for (int i=0; i < rowIndex+1; ++i) {
                result.add(cnk(rowIndex, i));
            }
        }
        return result;
    }
    
    private int cnk(int n, int k) {
        if (n == 0) {
            return 1;
        }
        long prod = 1;
        long div = 1;
        k = Math.min(k, n - k);
        for (int i=0; i < k; ++i) {
            prod *= (n-i);
            div *= (i+1);
            if ( (prod % div) == 0) {
                prod /= div;
                div = 1;
            }
        }
        return (int)(prod / div);
    }
}