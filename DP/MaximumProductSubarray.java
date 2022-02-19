package DP;



class MaximumProductSubarray  {
    public int maxProduct(int[] nums) {

        int result=Integer.MIN_VALUE;
        int size=nums.length;
        int current_max=1,current_min=1;

        for(int i=0;i<size;i++){
            if(nums[i]>result){
                result=nums[i];
            }
        }

        for(int i=0;i<size;i++){
            if(nums[i]==0){
                current_min=1;
                current_max=1;
                continue;
            }
            int temp=current_max*nums[i];
            current_max=Math.max(Math.max(nums[i]*current_max,nums[i]*current_min),nums[i]);
            current_min=Math.min(Math.min(temp,nums[i]*current_min),nums[i]);
            result=Math.max(result,current_max);
        }
        return result;
    }
}
