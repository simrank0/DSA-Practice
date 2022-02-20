package DP;

public class MaximumSumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int ans = nums[0];
        int cursum=nums[0];
        for(int i=1; i<nums.length; ++i){
            if(cursum<0){
                cursum=nums[i];
            }else{
                cursum += nums[i];
            }
            ans=Math.max(ans,cursum);
        }
        return ans;
    }
}
