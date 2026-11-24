from typing import List, Optional


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def generateTrees(self, n: int) -> List[Optional[TreeNode]]:
        if n <= 0:
            return []

        def build(start: int, end: int) -> List[Optional[TreeNode]]:
            if start > end:
                return [None]

            all_trees: List[Optional[TreeNode]] = []

            for root_val in range(start, end + 1):
                left_subtrees = build(start, root_val - 1)
                right_subtrees = build(root_val + 1, end)

                for left_node in left_subtrees:
                    for right_node in right_subtrees:
                        root = TreeNode(root_val)
                        root.left = left_node
                        root.right = right_node
                        all_trees.append(root)

            return all_trees

        return build(1, n)