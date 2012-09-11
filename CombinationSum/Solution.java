/**
 Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.

For example, given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3] 
*/

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSumHelper(candidates, target, 0);
    }

    private ArrayList<ArrayList<Integer>> combinationSumHelper(int[] candidates, int target, int start) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (start >= candidates.length) {
            return result;
        }
        for (int i=start; i < candidates.length; ++i) {
            int c = candidates[i];
            int t = target;
            int j = 0;
            while (t - c >= 0) {
                t -= c;
                ++j;
                if (t == 0) {
                    ArrayList<Integer> a = new ArrayList<Integer>();
                    for (int k=0; k < j; ++k) {
                        a.add(c);
                    }
                    result.add(a);
                    break;
                }
                for (ArrayList<Integer> r : combinationSumHelper(candidates, t, i+1)) {
                    ArrayList<Integer> a = new ArrayList<Integer>();
                    for (int k=0; k < j; ++k) {
                        a.add(c);
                    }
                    a.addAll(r);
                    Collections.sort(a);
                    result.add(a);
                }
            }
        }
        return result;
    }
}