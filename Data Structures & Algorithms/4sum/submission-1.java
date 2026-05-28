class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> l = new ArrayList<>();
        int n = nums.length;
        
        int i = 0;
        while (i < n - 3) {
            // Your skip logic for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }

            int j = i + 1;
            while (j < n - 2) {
                // Your skip logic for j
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }

                int a = j + 1;
                int b = n - 1;
                while (a < b) {
                    // Use long to prevent integer overflow errors
                    long sum = (long)nums[i] + nums[j] + nums[a] + nums[b];

                    if (sum == target) {
                        l.add(Arrays.asList(nums[i], nums[j], nums[a], nums[b]));
                        
                        // Skip duplicates for a and b
                        while (a < b && nums[a] == nums[a + 1]) a++;
                        while (a < b && nums[b] == nums[b - 1]) b--;
                        
                        a++;
                        b--;
                    } else if (sum < target) {
                        a++;
                    } else {
                        b--;
                    }
                }
                j++; // Manual increment for the j while loop
            }
            i++; // Manual increment for the i while loop
        }
        return l;
    }
}