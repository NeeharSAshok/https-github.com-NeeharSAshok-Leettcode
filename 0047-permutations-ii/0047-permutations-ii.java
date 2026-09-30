import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // If already visited, skip it
            if (visited[i]) continue;
            
            // If this element is a duplicate of the previous one and the previous
            // one hasn't been used yet, skip to avoid generating duplicate permutations
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            
            visited[i] = true;
            current.add(nums[i]);
            
            backtrack(nums, visited, current, result);
            
            // Backtrack
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}