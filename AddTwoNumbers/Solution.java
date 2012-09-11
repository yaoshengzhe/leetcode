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
    private int addTwoNumbersHelper(int sum, int carry, ListNode[] coll) {
        int digit = (sum + carry) % 10;
        carry = (sum + carry) / 10;

        if (coll[0] == null) {
            coll[0] = new ListNode(digit);
            coll[1] = coll[0];
        } else {
            coll[1].next = new ListNode(digit);
            coll[1] = coll[1].next;
        }
        return carry;
    }

    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        int carry = 0;
        ListNode[] coll = new ListNode[] {null, null};

        while (a != null && b != null) {
            carry = addTwoNumbersHelper(a.val + b.val, carry, coll);
            a = a.next;
            b = b.next;
        }

        while (a != null) {
            carry = addTwoNumbersHelper(a.val, carry, coll);
            a = a.next;
        }

        while (b != null) {
            carry = addTwoNumbersHelper(b.val, carry, coll);
            b = b.next;
        }

        if (carry > 0) {
            addTwoNumbersHelper(0, carry, coll);
        }
        return coll[0];
    }
}