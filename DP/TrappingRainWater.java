package DP;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int n = height.length;
        int[] maxRight= new int[n];
        int[] maxLeft= new int[n];
        maxRight[n-1] = height[n-1];
        for(int i = n-2; i>=0; i--){
            maxRight[i] = Math.max(maxRight[i+1], height[i]);
        }
        maxLeft[0] = height[0];
        for(int i = 1; i<n; i++){
            maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
        }

        int ans = 0;
        for(int i = 1; i<n-1; i++){
            ans+= (Math.min(maxLeft[i], maxRight[i])-height[i]);
        }
        return ans;
    }

    public static void main(String[] args){
        int h1[]= {4,2,0,3,2,5};
        System.out.println(trap(h1));
        int h2[]= {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(h2));
    }
}
