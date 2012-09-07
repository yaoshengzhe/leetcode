import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for (int i=0; i < num.length - 2; ++i) {
            for (int j=i+1; j < num.length - 1; ++j) {
                int target = -num[i] - num[j];
                if (Arrays.binarySearch(num, j + 1, num.length, target) >= 0) {
                    ArrayList<Integer> tuple = new ArrayList<Integer>();
                    tuple.add(num[i]);
                    tuple.add(num[j]);
                    tuple.add(target);
                    if (Collections.binarySearch(result, tuple, new TupleComparator()) < 0) {
                        result.add(tuple);
                    }
                }
            }
        }
        return result;
    }

    private class TupleComparator implements Comparator<ArrayList<Integer>> {
        @Override
        public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
            if (a.size() < b.size()) {
                return -1;
            } else if (a.size() > b.size()) {
                return 1;
            } else {
                for (int i=0; i < a.size(); ++i) {
                    if (a.get(i) > b.get(i)) {
                        return 1;
                    } else if (a.get(i) < b.get(i)) {
                        return -1;
                    }
                }
                return 0;
            }
        }
    }
}