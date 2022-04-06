package SortingAndSearching;

import java.util.Arrays;
import java.util.HashMap;

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int [] first=new int[intervals.length];
        for(int i=0;i<intervals.length;i++)
        {
            hm.put(intervals[i][0],i);
            first[i]=intervals[i][0];
        }
        Arrays.sort(first);
        int [] ans=new int[intervals.length];
        for(int k=0;k<intervals.length;k++)
        {
            int key=Arrays.binarySearch(first,intervals[k][1]);
            key=key<0?-key-1:key;
            if(key==first.length){
                ans[k]=-1;
            }
            else if(key==0)
            {
                if(intervals[k][1]<=first[0])
                    ans[k]=hm.get(first[0]);
                else{
                    ans[k]=-1;
                }
            }
            else{
                ans[k]=hm.get(first[key]);
            }


        }
        return ans;

    }
}
