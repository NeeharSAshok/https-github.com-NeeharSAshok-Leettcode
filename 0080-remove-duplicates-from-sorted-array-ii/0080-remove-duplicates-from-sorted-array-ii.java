class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        
        // The first two elements can always be safely kept
        int i = 2;
        
        for (int j = 2; j < nums.length; j++) {
            // Compare the current element with the element two positions before the write pointer.
            // If they are different, it means the current element has appeared fewer than twice 
            // in our newly forming valid array.
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }
        
        return i;
    }
}