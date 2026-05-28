class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                // Return 1-indexed array by adding 1 to both indices
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                // Sum is too small, move left pointer to a larger number
                left++;
            } else {
                // Sum is too large, move right pointer to a smaller number
                right--;
            }
        }
        
        return new int[0]; // Should never hit this based on problem constraints
    }
}