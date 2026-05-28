class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Set up our three pointers at the ends of their respective sections
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        // We only strictly need to continue while there are elements in nums2.
        // If nums2 is empty, the remaining elements in nums1 are already sorted in place!
        while (p2 >= 0) {
            
            // If p1 is valid AND the number in nums1 is bigger than the number in nums2
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                // Otherwise, the number in nums2 is bigger (or equal)
                nums1[p] = nums2[p2];
                p2--;
            }
            
            // Move our writing pointer down one step
            p--;
        }
    }
}