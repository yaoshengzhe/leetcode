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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        ListNode prev = null;
        for (int i=0; i < k; ++i) {
            if (p != null) {
                prev = p;
                p = p.next;
            } else {
                return head;
            }
        }
        
        ListNode remains = reverseKGroup(p, k);
        ListNode mid = head;
        prev.next = null;
        head = reverse(head);
        mid.next = remains;
        return head;
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode remains = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return remains;
    }
}