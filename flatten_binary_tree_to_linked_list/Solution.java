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
    // iterative
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode p = root.left;
                while (p.right != null) {
                    p = p.right;
                }
                p.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    // recursive
    public void flatten(TreeNode root) {
        helper(root);
    }

    TreeNode helper(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = helper(node.left);
        TreeNode right = helper(node.right);

        if (left != null) {
            left.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        if (right == null) {
            return left == null ? node : left;
        } else {
            return right;
        }
    }
}
