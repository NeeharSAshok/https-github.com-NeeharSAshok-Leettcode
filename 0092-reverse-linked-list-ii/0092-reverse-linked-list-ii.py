from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseBetween(
        self, head: Optional[ListNode], left: int, right: int
    ) -> Optional[ListNode]:
        if not head or left == right:
            return head

        dummy = ListNode(0, head)
        prev = dummy

        # 1. Move `prev` to the node immediately preceding `left`
        for _ in range(left - 1):
            prev = prev.next

        # `curr` stays at the node that will become the tail of the reversed slice
        curr = prev.next

        # 2. Repeatedly move the node after `curr` to right after `prev`
        for _ in range(right - left):
            to_move = curr.next
            curr.next = to_move.next
            to_move.next = prev.next
            prev.next = to_move

        return dummy.next