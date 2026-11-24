class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        m, n = len(s1), len(s2)
        if m + n != len(s3):
            return False

        dp = [False] * (n + 1)
        dp[0] = True

        # Base row: using 0 characters from s1 and j characters from s2
        for j in range(1, n + 1):
            dp[j] = dp[j - 1] and s2[j - 1] == s3[j - 1]

        # Fill row by row for i = 1..m characters from s1
        for i in range(1, m + 1):
            dp[0] = dp[0] and s1[i - 1] == s3[i - 1]
            for j in range(1, n + 1):
                k = i + j - 1
                from_s1 = dp[j] and s1[i - 1] == s3[k]
                from_s2 = dp[j - 1] and s2[j - 1] == s3[k]
                dp[j] = from_s1 or from_s2

        return dp[n]