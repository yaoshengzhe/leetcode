/**
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return result;
        }

        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                arr.add(root.val);
                result.add(arr);
            }
            return result;
        }

        for (ArrayList<Integer> i : pathSum(root.left, sum - root.val)) {
            i.add(0, root.val);
            result.add(i);
        }

        for (ArrayList<Integer> i : pathSum(root.right, sum - root.val)) {
            i.add(0, root.val);
            result.add(i);
        }
        return result;
    }
}
