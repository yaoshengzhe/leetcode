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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            if (head.val >= x && head.next.val < x) {
                ListNode p = head.next;
                p.next = head;
                head.next = null;
                return p;
            } else {
                return head;
            }
        }

        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;
        ListNode first = partition(head, x);
        ListNode second = partition(next, x);
        return merge(first, second, x);
    }

    private ListNode findMid(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode a, ListNode b, int x) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        } else {
            if (a.val < x) {
                ListNode remains = merge(a.next, b, x);
                a.next = remains;
                return a;
            } else if (b.val < x) {
                ListNode remains = merge(a, b.next, x);
                b.next = remains;
                return b;
            } else {
                ListNode remains = merge(a.next, b, x);
                a.next = remains;
                return a;
            }
        }
    }
}
