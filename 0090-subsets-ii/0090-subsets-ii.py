from typing import List


class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        result: List[List[int]] = []
        current: List[int] = []

        def backtrack(start: int) -> None:
            result.append(current.copy())

            for i in range(start, len(nums)):
                if i > start and nums[i] == nums[i - 1]:
                    continue

                current.append(nums[i])
                backtrack(i + 1)
                current.pop()

        backtrack(0)
        return result