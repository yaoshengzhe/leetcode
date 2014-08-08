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
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        for (int i=0; i < n; ++i) {
            if (p == null) {
                p = head;
            }
            p = p.next;
        }
        if (p == null) {
            return head;
        }
        ListNode q = head;
        while (p.next != null) {
            q = q.next;
            p = p.next;
        }
        p.next = head;
        head = q.next;
        q.next = null;
        return head;
    }
}
