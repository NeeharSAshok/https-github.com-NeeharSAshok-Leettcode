class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return true;
            }
            
            // Handle duplicates: when left, mid, and right have the same values, 
            // we cannot determine which half is sorted, so we shrink the boundary.
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                // Left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target lies within the sorted left half
                } else {
                    left = mid + 1;  // Target lies in the right half
                }
            } else {
                // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // Target lies within the sorted right half
                } else {
                    right = mid - 1; // Target lies in the left half
                }
            }
        }
        
        return false;
    }
}