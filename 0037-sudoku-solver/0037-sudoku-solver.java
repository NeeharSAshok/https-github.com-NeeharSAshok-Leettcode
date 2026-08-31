class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            
                            if (solve(board)) {
                                return true;
                            }
                            
                            board[i][j] = '.'; // Backtrack
                        }
                    }
                    return false; // Trigger backtracking if no digit fits
                }
            }
        }
        return true; // Board is fully solved
    }
    
    private boolean isValid(char[][] board, int row, int col, char c) {
        int boxRowStart = (row / 3) * 3;
        int boxColStart = (col / 3) * 3;
        
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false; // Check row
            if (board[i][col] == c) return false; // Check column
            if (board[boxRowStart + (i / 3)][boxColStart + (i % 3)] == c) return false; // Check 3x3 box
        }
        
        return true;
    }
}