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
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null) {
            return null;
        }
        return sortedArrayToBSTHelper(num, 0, num.length);
    }
    
    private TreeNode sortedArrayToBSTHelper(int[] num, int start, int end) {
        if (start >= end) {
            return null;
        }
        int median = start + (end - start) / 2;
        TreeNode root = new TreeNode(num[median]);
        root.left = sortedArrayToBSTHelper(num, start, median);
        root.right = sortedArrayToBSTHelper(num, median+1, end);
        return root;
    }
}