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
    public ListNode partition(ListNode head, int x) {
        // Create two dummy heads to maintain the "less than x" and "greater than or equal to x" lists
        ListNode lessHead = new ListNode(0);
        ListNode lessTail = lessHead;
        
        ListNode greaterHead = new ListNode(0);
        ListNode greaterTail = greaterHead;
        
        ListNode curr = head;
        
        // Traverse the original list and distribute nodes into the two partitions
        while (curr != null) {
            if (curr.val < x) {
                lessTail.next = curr;
                lessTail = lessTail.next;
            } else {
                greaterTail.next = curr;
                greaterTail = greaterTail.next;
            }
            curr = curr.next;
        }
        
        // Crucial: terminate the greater list to avoid infinite cycles in the linked list
        greaterTail.next = null;
        
        // Connect the end of the "less" list to the start of the "greater" list
        lessTail.next = greaterHead.next;
        
        return lessHead.next;
    }
}