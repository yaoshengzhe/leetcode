import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        return subsetsWithDupHelper(num, 0);
    }
    
    private ArrayList<ArrayList<Integer>> subsetsWithDupHelper(int[] num, int start) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length <= start) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        int target = num[start];
        int dupLen = 0;
        while (start < num.length && target == num[start]) {
            dupLen++;
            start++;
        }
        
        ArrayList<ArrayList<Integer>> subset = subsetsWithDupHelper(num, start);
        for (ArrayList<Integer> sub : subset) {
            result.add(sub);
            for (int i=1; i < dupLen+1; ++i) {
                ArrayList<Integer> r = new ArrayList<Integer>();
                for (int j=0; j < i; ++j) {
                    r.add(target);
                }
                r.addAll(sub);
                result.add(r);
            }
        }
        return result;
    }
}