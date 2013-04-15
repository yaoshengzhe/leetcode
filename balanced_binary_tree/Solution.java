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
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root) >= 0;
    }
    
    private int isBalancedHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = isBalancedHelper(node.left);
        if (left == -1) {
            return -1;
        }
        int right = isBalancedHelper(node.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) <= 1) {
            return Math.max(left, right) + 1;
        } else {
            return -1;
        }
    }
}