package SortingAndSearching;

public class MinimumSizeSubarrySum {
    public static void main(String[] args) {
        MinimumSizeSubarrySum obj = new MinimumSizeSubarrySum();
        int[] a = {2,3,1,2,4,3};
        int[] b = {1, 1, 1, 1, 1, 1};
        int[] c = {1, 4, 4};
        //Expected: 2
        System.out.println(obj.minSubArrayLen(7, a));
        System.out.println(obj.minSubArrayLen(11, b));
        System.out.println(obj.minSubArrayLen(4, c));
    }
    public int minSubArrayLen(int target, int[] a) {
        if (a == null || a.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < a.length) {
            sum += a[j++];

            while (sum >= target) {
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
