/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1. Compute length and find the tail
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // 2. Reduce k modulo length
        k %= length;
        if (k == 0) {
            return head;
        }

        // 3. Connect tail to head to form a circle
        tail.next = head;

        // 4. Advance (length - k - 1) steps to find the new tail
        int stepsToNewTail = length - k - 1;
        ListNode newTail = head;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}