from collections import deque
from typing import List, Optional


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        result: List[List[int]] = []
        queue: deque[TreeNode] = deque([root])
        level_index = 0

        while queue:
            level_size = len(queue)
            current_level: List[int] = []

            for _ in range(level_size):
                node = queue.popleft()
                current_level.append(node.val)

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            if level_index % 2 == 1:
                current_level.reverse()

            result.append(current_level)
            level_index += 1

        return result