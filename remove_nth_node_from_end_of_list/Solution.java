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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        for (int i=0; i < n; ++i) {
            p = p.next;
        }
        ListNode prev = head;
        ListNode cur = head;
        while (p != null) {
            prev = cur;
            cur = cur.next;
            p = p.next;
        }
        if (prev == cur) {
            return head.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}