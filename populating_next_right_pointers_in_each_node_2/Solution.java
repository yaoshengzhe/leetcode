/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

import java.util.Queue;
import java.util.LinkedList;
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        TreeLinkNode cur = root;
        while (cur != null) {
    
            if (cur.left != null) {
                if (cur.right != null) {
                    cur.left.next = cur.right;
                } else {
                    cur.left.next = findNext(cur.next);
                }
                queue.offer(cur.left);
            }
    
            if (cur.right != null) {
                cur.right.next = findNext(cur.next);
                queue.offer(cur.right);
            }
    
            cur = queue.poll();
        }
    }

    private TreeLinkNode findNext(TreeLinkNode node) {
        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            return findNext(node.next);
        }

        if (node.left != null) {
            return node.left;
        }

        if (node.right != null) {
            return node.right;
        }

        return null;
    } 
}