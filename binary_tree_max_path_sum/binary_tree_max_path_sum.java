/**
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6 
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

import java.lang.Math;

public class Solution {
    class MaxVal {
        public int val;
    };
    public int maxPathSum(TreeNode root) {
        MaxVal max = new MaxVal();
        max.val = Integer.MIN_VALUE;
        maxPathSumHelper(root, max);
        return max.val;
    }

    private int maxPathSumHelper(TreeNode root, MaxVal max) {
        if (root == null) {
            return 0;
        }

        int maxPathSumEndInLeft = maxPathSumHelper(root.left, max);
        int maxPathSumEndInRight = maxPathSumHelper(root.right, max);

        int val = root.val;
        if (maxPathSumEndInLeft > 0) {
            val += maxPathSumEndInLeft;
        }

        if (maxPathSumEndInRight > 0) {
            val += maxPathSumEndInRight;
        }

        max.val = Math.max(max.val, val);

        int s = Math.max(maxPathSumEndInLeft, maxPathSumEndInRight);

        return s > 0 ? s + root.val : root.val;
    }
}
