import java.lang.Math;

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int[] minPath = new int[triangle.size()];
        minPath[0] = 0;
        for (int i=0; i < triangle.size(); ++i) {
            ArrayList<Integer> row = triangle.get(i);
            for (int j=i; j > -1; --j) {
                int left = Math.max(0, j-1);
                int right = Math.max(0, Math.min(i-1, j));
                
                minPath[j] = Math.min(minPath[left], minPath[right]) + row.get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i : minPath) {
            min = Math.min(min, i);
        }
        return min;
    }
}