class Solution {
    public int maxProfit(int[] nums) {
        int min=0,max=0,profit=0;
        for(int i=0;i<nums.length;i++){
            if (nums[i]<=nums[min]){
                min=i;
            }
            else{
                max=i;
            }
            if(max>min&&nums[max]>nums[min]){
                if(nums[max]-nums[min]>profit){
                    profit=nums[max]-nums[min];
                }
            }
        }
        return profit;
    }
}
