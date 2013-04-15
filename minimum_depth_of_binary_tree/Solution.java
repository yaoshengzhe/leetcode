/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int minDepth = 1;
        int queueSize = 1;
        while (queueSize > 0) {
            int newQueueSize = 0;
            int i=0;
            for (; i < queueSize; ++i) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    break;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                    newQueueSize++;
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    newQueueSize++;
                }    
            }
            if (i != queueSize) {
                break;
            }
            queueSize = newQueueSize;
            minDepth++;
        }
        return minDepth;
    }
}