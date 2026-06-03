class Solution {
    public int minSubArrayLen(int target, int[] nums) {
      int l=0,r=0,csum=0,lengths=999999;  
      while (r < nums.length) {
    csum += nums[r]; // Always add the right element first
    r++;             // Expand the window

    // Shrink the window as much as possible while sum >= target
    while (csum >= target) {
        int currentLength = r - l; // Window is now nums[l...r-1]
        lengths = Math.min(lengths, currentLength);
        
        csum -= nums[l]; // Subtract the left element
        l++;             // Shrink from the left
    }
}
    if (lengths < 999999 )
        return lengths;
    else
        return 0;
    }
}