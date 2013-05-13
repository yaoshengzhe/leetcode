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
        if (head == null || n == 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = head;
        for (int i=1; i < n; ++i) {
            if (tail.next == null) {
                tail = head;
            } else {
                tail = tail.next;
            }
        }
        // [head, tail] = n
        ListNode prev = dummy;
        while (tail.next != null) {
            prev = prev.next;
            tail = tail.next;
        }
        if (prev == dummy) {
            return head;
        }
        ListNode newHead = prev.next;
        tail.next = head;
        prev.next = null;

        return newHead;
    }
}