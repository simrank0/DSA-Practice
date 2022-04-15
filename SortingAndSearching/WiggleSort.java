package SortingAndSearching;

import java.util.Arrays;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if(nums.length < 2) {
            return;
        }
        Arrays.sort(nums);
        int[] ans = new int[nums.length];
        int j = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            ans[j] = nums[i];
            j = j + 2;
            if(j >= nums.length) {
                j = 0;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }

    }
}
