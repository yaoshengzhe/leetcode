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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i=1; i < m; ++i) {
            prev = prev.next;
        }
        ListNode p = prev;
        ListNode start = prev.next;
        for (int i=m; i <= n; ++i) {
            ListNode next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
        if (p.next != null) {
            p.next.next = start;
        }
        p.next = prev;
        return dummy.next;
    }
}