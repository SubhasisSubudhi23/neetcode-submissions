class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int idx = 0; idx < nums.length; idx++) {
            map.put(idx, nums[idx]);
        }
        for (Map.Entry<Integer, Integer> entry1 : map.entrySet()) {
            
            int currentIndex = entry1.getKey();    
            int currentNumber = entry1.getValue(); 
            int d = target - currentNumber;        
            for (Map.Entry<Integer, Integer> entry2 : map.entrySet()) {
                if (entry2.getValue() == d && entry2.getKey() != currentIndex) {
                    int[] a = { currentIndex, entry2.getKey() };
                    return a;
                }
            }
        }
        return new int[]{}; 
    }
}
