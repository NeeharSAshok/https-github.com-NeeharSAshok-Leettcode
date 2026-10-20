class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
        // Base case: if the combination has reached size k, add it to the result
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        // Pruning optimization: Only loop up to n - (k - tempList.size()) + 1 
        // to ensure there are enough remaining elements to form a size-k combination.
        for (int i = start; i <= n - (k - tempList.size()) + 1; i++) {
            tempList.add(i);
            backtrack(result, tempList, i + 1, n, k);
            tempList.remove(tempList.size() - 1);
        }
    }
}