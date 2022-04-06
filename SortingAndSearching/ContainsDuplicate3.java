package SortingAndSearching;

import java.util.TreeSet;

public class ContainsDuplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            Long el = Long.valueOf(nums[i]);
            Long floor = set.floor(el);

            Long ceil = set.ceiling(el);
            if(floor!=null && Math.abs(floor-el)<=t){
                return true;
            }
            if(ceil!=null && Math.abs(ceil-el)<=t){
                return true;
            }
            set.add(el);
            if(set.size()>k){
                set.remove(Long.valueOf(nums[i-k]));
            }

        }
        return false;
    }
}
