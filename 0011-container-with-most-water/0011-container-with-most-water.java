class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        
        while (left < right) {
            // Calculate the current container area
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int currentWater = currentHeight * currentWidth;
            
            // Update maximum water found
            maxWater = Math.max(maxWater, currentWater);
            
            // Move the pointer of the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxWater;
    }
}