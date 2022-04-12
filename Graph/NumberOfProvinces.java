package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<isConnected.length; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<isConnected.length; i++){
            for(int j = 0; j<isConnected.length; j++){
                if(isConnected[i][j]==1) adj.get(i).add(j);
            }
        }
        return kosaRaju(adj, isConnected.length);
    }
    int kosaRaju(ArrayList<ArrayList<Integer>> adj, int N) {
        int[] vis = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) if (vis[i] == 0) dfs(i, stack, adj, vis);
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            transpose.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            vis[i] = 0;
            for (Integer it : adj.get(i))
                transpose.get(it).add(i);
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            int node = stack.peek();
            stack.pop();
            if (vis[node] == 0) {
                // System.out.print("SCC: ");
                ans++;
                revDFS(node, transpose, vis);
                // System.out.println();
            }
        }
        return ans;
    }

    void revDFS(int node, ArrayList<ArrayList<Integer>> transpose, int[] vis) {
        vis[node] = 1;
        // System.out.print(node + " ");
        for(Integer it: transpose.get(node))
            if(vis[it]==0)
                revDFS(it, transpose, vis);
    }

    void dfs(int node, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[node] = 1;
        for (Integer it : adj.get(node))
            if (vis[it] == 0) dfs(it, stack, adj, vis);
        stack.push(node);
    }
}
