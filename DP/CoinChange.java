package DP;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp =new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int denomination:coins){
            for(int i=1; i<dp.length; ++i ){
                if(denomination<=i && dp[i-denomination]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],dp[i-denomination]+1);
                }


            }
        }

        if(dp[amount]==Integer.MAX_VALUE)
            return -1;
        return dp[amount];
    }
}
