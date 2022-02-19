package DP;

public class MaximumSumIncreasingSubsequence {
    public int maxSumIS(int arr[], int n)
    {
        int[] dp = new int[n];

        int max= Integer.MIN_VALUE;
        for(int i=0; i<n; ++i){
            dp[i]=arr[i];
            for(int j=0;j<i;++j){
                if(arr[j]<arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+arr[i]);

                }


            }
            max=Math.max(max,dp[i]);

        }
        return max;
    }
}
