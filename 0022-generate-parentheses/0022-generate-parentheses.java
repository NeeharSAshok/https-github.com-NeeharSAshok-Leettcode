import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // If the current string has reached the maximum length of 2 * n, add it to the result
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }
        
        // We can add an opening parenthesis if we haven't used all n open parentheses
        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
        
        // We can add a closing parenthesis if the number of closing parentheses is less than opening ones
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}