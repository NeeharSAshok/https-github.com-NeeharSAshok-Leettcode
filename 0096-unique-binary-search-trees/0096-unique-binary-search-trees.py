class Solution:
    def numTrees(self, n: int) -> int:
        # dp[k] stores the number of unique BSTs with k nodes
        dp = [0] * (n + 1)
        dp[0] = 1
        dp[1] = 1

        for nodes in range(2, n + 1):
            for root in range(1, nodes + 1):
                left_count = dp[root - 1]
                right_count = dp[nodes - root]
                dp[nodes] += left_count * right_count

        return dp[n]