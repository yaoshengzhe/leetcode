/**
 Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.

For example, given candidate set 10,1,2,7,6,1,5 and target 8,
A solution set is:
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]

*/

import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Map<Integer, Integer> uniqNumMap = new TreeMap<Integer, Integer>();
        for (int n : num) {
            if (uniqNumMap.containsKey(n)) {
                uniqNumMap.put(n, uniqNumMap.get(n) + 1);
            } else {
                uniqNumMap.put(n, 1);
            }
        }
        Integer[] uniqNum = uniqNumMap.keySet().toArray(new Integer[0]);
        Arrays.sort(uniqNum);
        int[] freq = new int[uniqNum.length];
        for (int i=0; i < freq.length; ++i) {
            freq[i] = uniqNumMap.get(uniqNum[i]);
        }

        return combinationSum2Helper(uniqNum, freq, target, 0);
    }

    private ArrayList<ArrayList<Integer>> combinationSum2Helper(Integer[] num, int[] freq, int target, int start) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (start >= num.length) {
            return result;
        }
        for (int i=start; i < num.length; ++i) {
            int t = target;
            int j = freq[i];
            while (t - num[i] >= 0 && j > 0) {
                t -= num[i];
                --j;
                if (t == 0) {
                    ArrayList<Integer> sol = new ArrayList<Integer>();
                    for (int k=j; k < freq[i]; ++k) {
                        sol.add(num[i]);
                    }
                    result.add(sol);
                    break;
                } else {
                    for (ArrayList<Integer> subSol : combinationSum2Helper(num, freq, t, i+1)) {
                        ArrayList<Integer> sol = new ArrayList<Integer>();
                        for (int k=j; k < freq[i]; ++k) {
                            sol.add(num[i]);
                        }
                        sol.addAll(subSol);
                        Collections.sort(sol);
                        result.add(sol);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new Solution().combinationSum2(new int[] {8,7,4,3}, 11);
        for (ArrayList<Integer> r : result) {
            for (int i : r) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }
}