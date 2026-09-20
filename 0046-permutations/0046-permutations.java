class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        // If the temporary list matches the size of nums, we found a complete permutation
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue; // Skip elements that are already used in the current permutation
            }
            
            used[i] = true;
            tempList.add(nums[i]);
            
            // Recurse to build the rest of the permutation
            backtrack(result, tempList, nums, used);
            
            // Backtrack: undo the choice
            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }
    }
}