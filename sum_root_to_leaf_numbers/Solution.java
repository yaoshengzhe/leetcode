/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
import java.util.List;
import java.util.ArrayList;

public class Solution {
    private static class Result {
        public int val;
        public Result(int val) {
            this.val = val;
        }
    }
    
    public int sumNumbers(TreeNode root) {
        Result r = new Result(0);
        sumNumbersHelper(root, new ArrayList<Integer>(), r);
        return r.val;
    }
    
    private void sumNumbersHelper(TreeNode root, List<Integer> path, Result r) {
        if (root == null) {
            return;
        }
    
        if (root.left == null && root.right == null) {
            int num = 0;
            for (int i : path) {
                num = 10 * num + i;
            }
            r.val += (10 * num + root.val);
            return;
        }
        
        path.add(root.val);
        sumNumbersHelper(root.left, path, r);
        sumNumbersHelper(root.right, path, r);
        path.remove(path.size() - 1);
    }
    
}