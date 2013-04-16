public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (n == k) {
            ArrayList<Integer> r = new ArrayList<Integer>();
            for (int i=1; i < n+1; ++i) {
                r.add(i);
            }
            result.add(r);
            return result;
        }
        if (k == 0 || n == 0 || n < k) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        ArrayList<ArrayList<Integer>> resultWithoutN = combine(n-1, k);
        ArrayList<ArrayList<Integer>> resultWithN = combine(n-1, k-1);
        
        for (ArrayList<Integer> i : resultWithN) {
            i.add(n);
        }
        
        for (ArrayList<Integer> i : resultWithoutN) {
            result.add(new ArrayList<Integer>(i));
        }
        
        
        for (ArrayList<Integer> i : resultWithN) {
            result.add(new ArrayList<Integer>(i));
        }
        return result; 
    }
}