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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // reverse head && head.next
        ListNode remains = swapPairs(head.next.next);
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = remains;
        return newHead;
    }
}