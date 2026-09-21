class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        // If the remaining target becomes negative, this path exceeds the sum
        if (remain < 0) {
            return;
        } 
        // If remaining target is 0, we found a valid combination
        else if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        // Iterate through candidates starting from 'start' to avoid duplicate combinations
        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            // Pass 'i' instead of 'i + 1' to allow reusing the same element
            backtrack(result, tempList, candidates, remain - candidates[i], i);
            // Backtrack: undo the choice
            tempList.remove(tempList.size() - 1);
        }
    }
}