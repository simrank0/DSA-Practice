package DP;

import java.util.Arrays;

public class MatrixChainMultiplication {
    static int dp[][]=new int[1005][1005];
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        for (int[] row: dp) Arrays.fill(row, -1);
        int min=Integer.MAX_VALUE;
        return helper(arr,N,1,N-1,min);
    }
    static int helper(int[] arr,int n,int i,int j,int min){
        if(i>=j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int k=i;k<=j-1;k++){
            int tempAns=helper(arr,n,i,k,min) + helper(arr,n,k+1,j,min) + (arr[i-1]*arr[k]*arr[j]);
            min=Math.min(min,tempAns);
        }
        return dp[i][j]=min;
    }
}
