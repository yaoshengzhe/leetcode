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
    private static class OrderInfo {
        TreeNode first;
        TreeNode second;
        TreeNode pre;
        public OrderInfo(TreeNode first, TreeNode second, TreeNode pre) {
            this.first = first;
            this.second = second;
            this.pre = pre;
        }
    }

    public void recoverTree(TreeNode root) {
        OrderInfo info = new OrderInfo(null, null, null);
        inorder(root, info);
        int val = info.first.val;
        info.first.val = info.second.val;
        info.second.val = val;
    }

    private void inorder(TreeNode node, OrderInfo info) {
        if (node == null) {
            return;
        }
        inorder(node.left, info);
        if (info.pre == null) {
            info.pre = node;
        }
        if (info.pre.val > node.val) {
            if (info.first == null) {
                info.first = info.pre;
            }
            info.second = node;
        }
        info.pre = node;
        inorder(node.right, info);
    }
}
