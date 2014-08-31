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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int min = 0;
        while (queue != null) {
            int queueLen = queue.size();
            for (int i=0; i < queueLen; ++i) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return min + 1;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            min++;
        }
        return min;
    }
}
