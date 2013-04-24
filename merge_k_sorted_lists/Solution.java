/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.PriorityQueue;
import java.util.Comparator;

public class Solution {

    private static class IndexedNode {
        public ListNode node;
        public int index;
        
        public IndexedNode(ListNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        PriorityQueue<IndexedNode> heap = new PriorityQueue<IndexedNode>(lists.size(),
            new Comparator<IndexedNode>() {
                public int compare(IndexedNode a, IndexedNode b) {
                    return a.node.val - b.node.val;
                }
            });
        for (int i=0; i < lists.size(); ++i) {
            ListNode cur = lists.get(i);
            if (cur != null) {
                lists.set(i, cur.next);
                cur.next = null;
                heap.add(new IndexedNode(cur, i));
            }
        }
        
        ListNode head = null;
        ListNode tail = null;
        while (!heap.isEmpty()) {
            IndexedNode node = heap.poll();
            ListNode cur = lists.get(node.index);
            if (cur != null) {
                lists.set(node.index, cur.next);
                cur.next = null;
                heap.add(new IndexedNode(cur, node.index));
            }
            if (head == null) {
                head = node.node;
                tail = head;
            } else {
                tail.next = node.node;
                tail = tail.next;
            }
        }
        return head;
    }
}