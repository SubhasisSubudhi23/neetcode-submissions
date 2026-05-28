class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> pos=new HashSet<>();
        int i;
        for (i=0;i<nums.length;i++)
            pos.add(nums[i]);
        for(i=1;i<=nums.length;i++){
            if(pos.contains(i)==false){
                return i;
            }
        }
        return i;
    }
}