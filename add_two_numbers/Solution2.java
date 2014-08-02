/**
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

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
    private ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            return (carry > 0) ? new ListNode(carry) : null;
        }

        if (l1 == null) {
            return addTwoNumbersHelper(new ListNode(carry), l2, 0);
        } else if (l2 == null) {
            return addTwoNumbersHelper(new ListNode(carry), l1, 0);
        } else {
            int sum = l1.val + l2.val + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            node.next = addTwoNumbersHelper(l1.next, l2.next, carry);
            return node;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersHelper(l1, l2, 0);
    }
}
