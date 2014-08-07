import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        return combinationSum2Helper(num, target, 0);
    }

    private ArrayList<ArrayList<Integer>> combinationSum2Helper(int[] num, int target, int start) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (target == 0) {
            result.add(new ArrayList<Integer>());
        } else if (target > 0 && start < num.length) {
            int next = start + 1;
            for (; next < num.length; ++next) {
                if (num[start] != num[next]) {
                    break;
                }
            }
            for (int i=0; i < next - start; ++i) {
                for (ArrayList<Integer> sub : combinationSum2Helper(num, target - (i+1) * num[start], next)) {
                    for (int j=0; j < i+1; ++j) {
                        sub.add(0, num[start]);
                    }
                    result.add(sub);
                }
            }
            for (ArrayList<Integer> sub : combinationSum2Helper(num, target, next)) {
                result.add(sub);
            }
        }
        return result;
    }
}
