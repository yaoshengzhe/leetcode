/**
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
*/

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
        if (root == null) {
            return;
        }
        TreeNode lastNode = flattenHelper(root);
        root = lastNode.right;
        lastNode.right = null;
    }

    private TreeNode merge(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return (a == null) ? b : a;
        } else {
            TreeNode result = a.right;
            a.right = b.right;
            b.right = result;
            return b;
        }
    }

    private TreeNode flattenHelper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = flattenHelper(root.left);
        TreeNode right = flattenHelper(root.right);
        root.left = null;
        root.right = root;
        return merge(root, merge(left, right));
    }
}
