import java.util.Arrays;
import java.util.ArrayList;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Integer> buf = new LinkedList<Integer>();
        subsetWithDupHelper(num, 0, buf, result);
        return result;
    }

    private void subsetWithDupHelper(int[] num, int start, LinkedList<Integer> buf, List<List<Integer>> result) {
        if (start == num.length) {
            result.add(new ArrayList<Integer>(buf));
        } else {
            buf.add(num[start]);
            subsetWithDupHelper(num, start+1, buf, result);
            buf.removeLast();
            while (start < num.length - 1 && num[start] == num[start+1]) {
                start++;
            }
            subsetWithDupHelper(num, start+1, buf, result);
        }
    }
}
