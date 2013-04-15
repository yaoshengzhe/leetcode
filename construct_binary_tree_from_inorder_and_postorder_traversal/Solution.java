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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        return buildTreeHelper(inorder, postorder, postorder.length-1, 0, inorder.length);
    }
     
    private TreeNode buildTreeHelper(int[] inorder, int[] postorder,
                                      int idx, int start, int end) {
        if (start >= end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[idx]);
        int i=start;
        for (; i < end; ++i) {
            if (inorder[i] == root.val) {
                break;
            }
        }
        int numofright = end - i - 1;
        root.left = buildTreeHelper(inorder, postorder, idx-numofright-1, start, i);
        root.right = buildTreeHelper(inorder, postorder, idx-1, i+1, end);
        return root;
                                          
     }
}