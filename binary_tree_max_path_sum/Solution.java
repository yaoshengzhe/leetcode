import java.lang.Math;

public class Solution {
    private static class Result {
        public int val = Integer.MIN_VALUE;
    }
    
    public int maxPathSum(TreeNode root) {
        Result max = new Result();
        maxPathSumHelper(root, max);
        return max.val;
    }
    
    private int maxPathSumHelper(TreeNode node, Result max) {
        if (node == null) {
            return 0;
        }
        int a = maxPathSumHelper(node.left, max);
        int b = maxPathSumHelper(node.right, max);
        int c = Math.max(0, Math.max(a, b));  
        max.val = Math.max(max.val,  Math.max(c, a+b) + node.val);
        return c + node.val;
    }
        
}