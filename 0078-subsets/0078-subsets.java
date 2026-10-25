class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        // Every node in the backtracking tree represents a valid subset
        result.add(new ArrayList<>(tempList));
        
        for (int i = start; i < nums.length; i++) {
            // Choose the current element
            tempList.add(nums[i]);
            // Explore further with the next index
            backtrack(result, tempList, nums, i + 1);
            // Un-choose (backtrack) to explore other branches
            tempList.remove(tempList.size() - 1);
        }
    }
}