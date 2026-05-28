class Solution {
    public void sortColors(int[] nums) {
        int length=nums.length,c0=0,c1=0,c2=0;
        for (int i=0;i<length;i++){
            if (nums[i]==0)
                c0=c0+1;
            else if (nums[i]==1)
                c1=c1+1;
            else 
                c2=c2+1;
            
        }
        for (int i=0;i<length;i++){
            if (i<c0)
                nums[i]=0;
            else if(i>=c0 && i<(c0+c1))
                nums[i]=1;
            else 
                nums[i]=2;
        }
        
    }
}