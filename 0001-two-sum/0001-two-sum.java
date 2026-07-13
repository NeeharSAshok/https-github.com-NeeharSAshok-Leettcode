import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to store: Key = number, Value = its index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // If the complement is already in the map, we found the pair
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // Otherwise, add the current number and its index to the map
            map.put(nums[i], i);
        }
        
        // As per constraints, a solution always exists
        throw new IllegalArgumentException("No two sum solution found");
    }
}