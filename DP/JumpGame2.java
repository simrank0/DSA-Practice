package DP;

import java.util.Arrays;

public class JumpGame2 {
    public int jump(int[] nums) {
        int[] dp= new int[nums.length];
        dp[dp.length-1]=0;
        for(int i=dp.length-2; i>=0;--i){
            int min=Integer.MAX_VALUE;
            boolean minFound=false;
            if(nums[i]==0){
                dp[i]=Integer.MAX_VALUE;
                continue;
            }
            minFound=false;
            min=Integer.MAX_VALUE;
            for(int j=1;j<=nums[i]; ++j){

                if(i+j>=dp.length-1){
                    min=0;
                    minFound=true;
                    break;
                }
                if(min>dp[i+j]){
                    min=dp[i+j];
                    minFound=true;
                }

            }
            if(minFound)
                dp[i]=min+1;
            else
                dp[i]=min;
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}
