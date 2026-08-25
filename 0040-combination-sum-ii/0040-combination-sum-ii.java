import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array to handle duplicates and enable early breaking
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates at the same tree depth level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // Since the array is sorted, if the current element exceeds the remaining target, 
            // all subsequent elements will too, so we can break early.
            if (candidates[i] > remain) {
                break;
            }
            
            tempList.add(candidates[i]);
            // Use i + 1 because each element can only be used once
            backtrack(result, tempList, candidates, remain - candidates[i], i + 1);
            tempList.remove(tempList.size() - 1); // Backtrack
        }
    }
}