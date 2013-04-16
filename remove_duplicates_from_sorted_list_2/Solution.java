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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        while (p != null && p.next != null && p.val == p.next.val) {
            p = p.next;
        }
        if (p == null) {
            return null;
        } else if (p == head) {
            p.next = deleteDuplicates(p.next);
            return p;
        } else {
            return deleteDuplicates(p.next);
        }
    }
}