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
        ListNode lessThan = null;
        ListNode lessThanTail = null;
        ListNode greaterOrEq = null;
        ListNode greaterOrTail = null;

        while (head != null) {
            if (head.val < x) {
                // insert to lessThan
                if (lessThanTail == null) {
                    lessThan = lessThanTail = head;
                } else {
                    lessThanTail.next = head;
                    lessThanTail = head;
                }
            } else {
                // insert to greaterOrEq
                if (greaterOrTail == null) {
                    greaterOrEq = greaterOrTail = head;
                } else {
                    greaterOrTail.next = head;
                    greaterOrTail = head;
                }
            }
            head = head.next;
        }

        if (lessThanTail != null) {
            lessThanTail.next = null;
        }

        if (greaterOrTail != null) {
            greaterOrTail.next = null;
        }

        if (lessThan != null) {
            lessThanTail.next = greaterOrEq;
            return lessThan;
        } else {
            return greaterOrEq;
        }
    }
}
