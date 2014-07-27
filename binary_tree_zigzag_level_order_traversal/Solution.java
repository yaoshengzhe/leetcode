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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            boolean isEvenLevel = false;
            while (queue.size() > 0) {
                int size = queue.size();
                ArrayList<Integer> level = new ArrayList<Integer>(size);
                for (int i=0; i < size; ++i) {
                    level.add(0);
                }
                for (int i=0; i < size; ++i) {
                    TreeNode cur = queue.poll();

                    if (isEvenLevel) {
                        level.set(size - i - 1, cur.val);
                    } else {
                        level.set(i, cur.val);
                    }

                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                result.add(level);
                isEvenLevel = !isEvenLevel;
            }
            /*
            for (int i=1; i < result.size(); i += 2) {
                ArrayList<Integer> level = result.get(i);
                int  start = 0;
                int end = level.size()-1;
                while (start < end) {
                    int tmp = level.get(start);
                    level.set(start, level.get(end));
                    level.set(end, tmp);
                    start++;
                    end--;
                }
            } */
        }
        return result;
    }
}
    
