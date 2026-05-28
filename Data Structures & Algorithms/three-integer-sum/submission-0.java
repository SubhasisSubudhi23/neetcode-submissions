class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> l = new ArrayList<>();

    for (int p = 0; p < nums.length - 2; p++) {
        // 1. Skip Duplicate 'p' values to avoid duplicate triplets
        if (p > 0 && nums[p] == nums[p - 1]) continue;

        int i = p + 1; // Start i right after p
        int j = nums.length - 1;

        while (i < j) {
            int sum = nums[p] + nums[i] + nums[j];

            if (sum == 0) {
                l.add(Arrays.asList(nums[p], nums[i], nums[j]));
                
                // 2. Move pointers and SKIP duplicates for i and j
                while (i < j && nums[i] == nums[i + 1]) i++;
                while (i < j && nums[j] == nums[j - 1]) j--;
                
                i++;
                j--;
            } else if (sum < 0) {
                i++; // Sum too small, move left pointer right
            } else {
                j--; // Sum too large, move right pointer left
            }
        }
    }
    return l;
}
}
