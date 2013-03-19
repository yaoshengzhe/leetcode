/* @(#)Solution.java
 */
/**
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * @author Shengzhe Yao
 */

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        for (int i=0; i < s.length(); ++i) {
            String pre = s.substring(0, i+1);
            if (isPalindrome(s, 0, i)) {
                ArrayList<ArrayList<String>> r = partition(s.substring(i+1));
                if (r.isEmpty()) {
                    ArrayList<String> item = new ArrayList<String>();
                    item.add(pre);
                    result.add(item);
                } else {
                    for (ArrayList<String> item : r) {
                        item.add(0, pre);
                        result.add(item);
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }
}

