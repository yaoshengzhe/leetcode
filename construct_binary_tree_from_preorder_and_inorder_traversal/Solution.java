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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return buildTreeHelper(preorder, inorder, 0, 0, inorder.length);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int idx,
                                     int start, int end) {
        if (start >= end) {
            return null; 
        }               
        TreeNode root = new TreeNode(preorder[idx]);
        int i = start;
        for (; i < end; ++i) {
            if (inorder[i] == root.val) {
                break;
            }
        }
        root.left = buildTreeHelper(preorder, inorder, idx+1, start, i);
        root.right = buildTreeHelper(preorder, inorder, idx + i - start + 1, i+1, end);
        return root;
    }
}