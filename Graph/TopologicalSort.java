package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] indegree =new int[V];
        for(ArrayList<Integer> temp:adj){
            for(int i:temp){
                indegree[i]++;
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        bfs(adj,indegree,ans);
        int[] finalans =new int[V];
        int i=0;
        for(int j:ans){
            finalans[i++]=j;
        }
        return finalans;
    }
    static void bfs(ArrayList<ArrayList<Integer>> adj, int[] in, ArrayList<Integer>ans){

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<in.length;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        while(q.size()>0){
            int temp=q.poll();
            ans.add(temp);
            for(int i:adj.get(temp)){
                in[i]--;
                if(in[i]==0){
                    q.add(i);
                }
            }
        }
    }
}
