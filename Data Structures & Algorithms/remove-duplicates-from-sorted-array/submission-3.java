class Solution {
    public int removeDuplicates(int[] nums) {
        // Edge case: empty array
        if (nums == null || nums.length == 0) return 0;
        
        int j = 1; // Our "Writer" pointer starts at index 1
        
        // Our "Explorer" pointer (i) also starts at index 1
        for (int i = 1; i < nums.length; i++) {
            
            // If the current number is DIFFERENT from the one right behind it,
            // we found a brand new unique number!
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i]; // Write the new number at position j
                j++;               // Move the Writer forward one spot
            }
        }
        
        // 'j' now represents exactly how many unique numbers we wrote!
        return j; 
    }
}