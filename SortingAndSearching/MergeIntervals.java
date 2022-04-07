package SortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals1 = {{1,3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals2 = {{1,5}, {2, 3}, {8, 8}, {8, 18}};
        int[][] res = mergeIntervals.merge(intervals1);

        //Expected: [[1,6],[8,10],[15,18]]
        mergeIntervals.printArray(res);

        res = mergeIntervals.merge(intervals2);

        //Expected: [[1,5],[8,18]]
        mergeIntervals.printArray(res);
    }
    void printArray(int[][] arr){
        System.out.print("[ ");
        for(int[] a : arr){
            System.out.print(Arrays.toString(a) + " ");
        }
        System.out.println("]");

    }
}
