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
    public void flatten(TreeNode root) {
        TreeNode p = flattenHelper(root);
        if (p != null) {
            p.right = null;
        }
    }
    
    private TreeNode flattenHelper(TreeNode node) {
        if (node == null) {
            return null;
        }
        
        TreeNode left = flattenHelper(node.left);
        TreeNode right = flattenHelper(node.right);
        node.left = null;
        node.right = node;
        return merge(merge(node, left), right);
    }
    
    private TreeNode merge(TreeNode left, TreeNode right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            TreeNode head = left.right;
            left.right = right.right;
            right.right = head;
            return right;
        }
    }
}