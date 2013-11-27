/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode second = mid.next;
        mid.next = null;
        return merge(sortList(head), sortList(second));
    }

    ListNode getMid(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode slow, fast, mid;
        mid = slow = fast = node;
        while (fast != null && fast.next != null) {
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return mid;
    }

    ListNode merge(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        } else if (second == null) {
            return first;
        } else {
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            while (first != null && second != null) {
                if (first.val <= second.val) {
                    tail.next = first;
                    first = first.next;
                } else {
                    tail.next = second;
                    second = second.next;
                }
                tail = tail.next;
            }
            while (first != null) {
                tail.next = first;
                first = first.next;
                tail = tail.next;
            }
            while (second != null) {
                tail.next = second;
                second = second.next;
                tail = tail.next;
            }
            tail.next = null;
            return dummy.next;
        }
    }
}
