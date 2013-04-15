/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBSTHelper(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        return node.val >= min && node.val <= max
            && isValidBSTHelper(node.left, min, node.val-1)
            && isValidBSTHelper(node.right, node.val+1, max);
    }
}