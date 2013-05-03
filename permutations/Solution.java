public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        permuteHelper(num, result, 0);
        return result;
    }

    public void permuteHelper(int[] num, ArrayList<ArrayList<Integer>> result, int start) {
        if (start == num.length) {
            ArrayList<Integer> r = new ArrayList<Integer>();
            for (int n : num) {
                r.add(n);
            }
            result.add(r);
        } else {
            for (int i=start; i < num.length; ++i) {
                swap(num, i, start);
                permuteHelper(num, result, start+1);
                swap(num, i, start);
            }
        }
    }

   private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
