class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i = 0, j = 1; // Start j at i + 1
        
        // Ensure i doesn't go out of bounds and j stays ahead
        while (i < nums.length && j < nums.length) {
            
            // Check the condition: values are same AND distance is <= k
            if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                return true;
            }

            // Logic to move pointers
            if (j == nums.length - 1 || (j - i) >= k) {
                // If j hits the end OR j is already beyond distance k, move i
                i++;
                j = i + 1; // Reset j to start right after the new i
            } else {
                // Otherwise, keep sliding j forward
                j++;
            }
        }
        return false;
    }
}

