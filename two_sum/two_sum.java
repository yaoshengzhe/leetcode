/**
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, List<Integer>> table = new HashMap<Integer, List<Integer>>();
        for (int i=0; i < numbers.length; ++i) {
            int num = numbers[i];
            List<Integer> indexes = table.get(num);
            if (indexes == null) {
                indexes = new ArrayList<Integer>();
                indexes.add(i);
                table.put(num, indexes);
            } else {
                indexes.add(i);
            }
        }
        for (int i=0; i < numbers.length; ++i) {
            List<Integer> indexes = table.get(target - numbers[i]);
            if (indexes != null) {
                if (target-numbers[i] != numbers[i]) {
                    return new int[] {i+1, indexes.get(0)+1};
                } else {
                    if (indexes.size() > 1) {
                        return new int[] {i+1, indexes.get(1)+1};
                    }
                }
            }
        }
        return null;
    }
}
