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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return treeSymmetricEquals(root.left, root.right);
    }
    
    private boolean treeSymmetricEquals(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a != null && b != null) {
            return a.val == b.val && treeSymmetricEquals(a.left, b.right) && treeSymmetricEquals(a.right, b.left);
        } else {
            return false;
        }
    }
}