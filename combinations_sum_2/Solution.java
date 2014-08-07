public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Integer> buf = new LinkedList<Integer>();
        helper(num, 0, target, buf, result);
        return result;
    }

    void helper(int[] num, int start, int target, LinkedList<Integer> buf, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(buf));
            return;
        } else if (target < 0) {
            return;
        } else if (num.length == start) {
            return;
        }

        buf.addLast(num[start]);
        helper(num, start + 1, target - num[start], buf, result);
        buf.removeLast();

        while (start < num.length-1 && num[start] == num[start+1]) {
            start++;
        }
        helper(num, start + 1, target, buf, result);
    }
}
