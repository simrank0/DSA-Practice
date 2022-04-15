package Graph;

import java.util.*;

public class ParallelCourses3 {
    private Map<Integer,Integer> memo= new HashMap<>();
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> adj= new HashMap<>();
        Set<Integer> sources= new HashSet<>();
        for(int i=1;i<=n;++i) sources.add(i);

        for(int[] relation: relations){
            List<Integer> list=adj.getOrDefault(relation[0],new ArrayList<>());
            list.add(relation[1]);
            adj.put(relation[0],list);

            if(sources.contains(relation[1])) sources.remove(relation[1]);
        }
        int res=-0;


        for(int source:sources){
            res=Math.max(res,maxPath(adj,time,source));
        }
        return res;

    }
    private int maxPath(Map<Integer,List<Integer>> adj, int[] time,int cur){
        int res=0;

        if(!adj.containsKey(cur)) return time[cur-1];

        if(memo.containsKey(cur)) return memo.get(cur);

        for(int child:adj.get(cur)){
            res=Math.max(res,maxPath(adj,time,child));
        }


        memo.put(cur,res+time[cur-1]);
        return memo.get(cur) ;
    }
}
