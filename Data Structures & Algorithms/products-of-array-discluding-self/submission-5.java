class Solution {
    public int[] productExceptSelf(int[] nums) {
        int multi[]=new int[nums.length];
        Arrays.fill(multi, 1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j)
                    multi[i] = multi[i] * nums[j];
            }
        }
        return multi;
    }
}  
