class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List <Integer> max=new ArrayList<>();
        HashMap <Integer,Integer> val=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            val.put(nums[i],val.getOrDefault(nums[i], 0)+1);
        }
        for (Map.Entry<Integer, Integer> en : val.entrySet()) {
            Integer value = en.getValue();
            if (value>nums.length/3){
                max.add(en.getKey());
            }
        }
        return max;
    }
}