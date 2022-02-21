package DP;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int lastHopTo = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(i + nums[i] >= lastHopTo){
                lastHopTo = i;
            }
        }

        return lastHopTo == 0;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }
}
