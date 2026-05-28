class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            // 1. Calculate the width
            int width = right - left;
            
            // 2. Find the height (limited by the shorter bar)
            int h = Math.min(height[left], height[right]);
            
            // 3. Update maxWater if current area is larger
            int currentArea = width * h;
            if (currentArea > maxWater) {
                maxWater = currentArea;
            }

            // 4. Move the pointer pointing to the shorter bar
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}