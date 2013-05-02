import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSumHelper(candidates, target, 0);
    }

    private ArrayList<ArrayList<Integer>> combinationSumHelper(int[] candidates, int target, int start) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (target == 0) {
            result.add(new ArrayList<Integer>());
        } else if (target > 0 && start < candidates.length) {
            for (ArrayList<Integer> sub : combinationSumHelper(candidates, target - candidates[start], start)) {
                sub.add(0, candidates[start]);
                result.add(sub);
            }
            for (ArrayList<Integer> sub : combinationSumHelper(candidates, target, start+1)) {
                result.add(sub);
            }
        }
        return result;
    }
}
