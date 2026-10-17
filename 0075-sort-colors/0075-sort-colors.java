class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid], then advance both pointers
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // 1 is in the correct middle region, just advance mid
                mid++;
            } else {
                // Swap nums[mid] and nums[high], shrink the high boundary
                // Note: Do not advance mid here because the swapped element from 'high' 
                // still needs to be evaluated.
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}