package Graph;

import java.util.*;

public class isBipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<=graph.length; i++) adj.add(new ArrayList<>());
        for(int i = 0; i<graph.length; i++)
            for(int j = 0; j<graph[i].length; j++){
                adj.get(i).add(graph[i][j]);
                adj.get(graph[i][j]).add(i);
            }
        return checkBipartiteDFS(adj, graph.length-1);
//        return checkBipartiteBFS(adj, graph.length-1);
    }
     boolean checkBipartiteBFS(List<List<Integer>> adj, int n){
         int[] color = new int[n+1];
         Arrays.fill(color, -1);
         for(int i = 1; i<=n; i++){
             if(color[i]==-1){
                 if(!checkBFS(adj, color, i)) return false;
             }
         }
         return true;
     }

         boolean checkBFS(List<List<Integer>> adj, int[] color, int i){
         Queue<Integer> q = new LinkedList<>();
         q.add(i);
         color[i] = 1;
         while(!q.isEmpty()){
             Integer node = q.poll();
             for(int n: adj.get(node)){
                 if(color[n] == -1){
                     color[n] = 1 - color[node];
                     q.add(n);
                 }else if(color[n] == color[node]) return false;
             }
         }
         return true;
     }
    boolean checkBipartiteDFS(List<List<Integer>> adj, int n){
        int[] color = new int[n+1];
        Arrays.fill(color, -1);
        for(int i = 1; i<=n; i++){
            if(color[i]==-1){
                if(checkDFS(adj, color, i)) return false;
            }
        }
        return true;
    }

    boolean checkDFS(List<List<Integer>> adj, int[] color, int i){
        if(color[i] == -1) color[i] = 1;
        for(Integer it : adj.get(i)){
            if(color[it] == -1) {
                color[it] = 1 - color[i];
                if(checkDFS(adj, color, it)) return true;
            }else if(color[it] == color[i]) return true;
        }
        return false;
    }
}
