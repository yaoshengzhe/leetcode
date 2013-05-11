public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i=0; i < (1 << n); ++i) {
            result.add( (i >> 1) ^ i);
        }
        return result;
    }
}