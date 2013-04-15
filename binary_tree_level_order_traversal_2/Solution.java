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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            
            while (queue.size() > 0) {
                int size = queue.size();
                ArrayList<Integer> level = new ArrayList<Integer>();
                for (int i=0; i < size; ++i) {
                    TreeNode cur = queue.poll();
                    level.add(cur.val);
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                result.add(level);
            }
        }
        int start = 0;
        int end = result.size() - 1;
        while (start < end) {
            ArrayList<Integer> tmp = result.get(start);
            result.set(start, result.get(end));
            result.set(end, tmp);
            start++;
            end--;
        }
        return result;
    }
}