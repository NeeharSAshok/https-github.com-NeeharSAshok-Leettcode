class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Use a 1D rolling array for space optimization, 
        // storing the minimum path sum for the current row.
        int[] dp = new int[n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    // Starting cell
                    dp[j] = grid[i][j];
                } else if (i == 0) {
                    // First row: can only come from the left
                    dp[j] = dp[j - 1] + grid[i][j];
                } else if (j == 0) {
                    // First column: can only come from above
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    // General case: choose the minimum between coming from above (dp[j]) and left (dp[j-1])
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }
        
        return dp[n - 1];
    }
}