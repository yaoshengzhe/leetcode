/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.lang.Math;
public class Solution {
    private static class Result {
        public int val = 0;
    }
    
    public int maxDepth(TreeNode root) {
        Result max = new Result();
        maxDepthHelper(root, max, 0);
        return max.val;
    }
    
    private void maxDepthHelper(TreeNode root, Result max, int depth) {
        if (root == null) {
            max.val = Math.max(max.val, depth);
        } else {
            maxDepthHelper(root.left, max, depth+1);
            maxDepthHelper(root.right, max, depth+1);
        }
    }
}