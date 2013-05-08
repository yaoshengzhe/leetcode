/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        int[] arr = new int[n];
        for (int i=0; i < n; ++i) {
            arr[i] = i+1;
        }
        return generateTreesHelper(arr, 0, arr.length);
    }

    private ArrayList<TreeNode> generateTreesHelper(int[] arr, int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (start == end) {
            result.add(null);
        }
        for (int i=start; i < end; ++i) {
            for (TreeNode left : generateTreesHelper(arr, start, i)) {
                for (TreeNode right : generateTreesHelper(arr, i+1, end)) {
                    TreeNode root = new TreeNode(arr[i]);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
