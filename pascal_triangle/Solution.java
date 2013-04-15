import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numRows < 1) {
            return result;
        }
        result.add(new ArrayList(Arrays.asList(1)));
        for (int i=1; i < numRows; ++i) {
            ArrayList<Integer> prev = result.get(i-1);
            ArrayList<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for (int j=1; j < i; ++j) {
                cur.add(prev.get(j-1) + prev.get(j));
            }
            cur.add(1);
            result.add(cur);
        }
        return result;
    }
}