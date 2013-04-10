import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        return subsetsHelper(S, 0);
    }
    
    private ArrayList<ArrayList<Integer>> subsetsHelper(int[] S, int start) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (S == null || start >= S.length) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        for (ArrayList<Integer> sub : subsetsHelper(S, start+1)) {
            result.add(sub);
            ArrayList<Integer> arr = new ArrayList<Integer>();
            arr.add(S[start]);
            arr.addAll(sub);
            result.add(arr);
        }
        return result;
    }
}