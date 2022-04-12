package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubmergingIsland {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        while (n != m || n != 0) {
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                adj.get(a).add(b);
                adj.get(b).add(a);
            }
            SubmergingIsland obj = new SubmergingIsland();
            obj.printArticulation(adj, n);
            n = in.nextInt();
            m = in.nextInt();
        }
    }

    void printArticulation(List<List<Integer>> adj, int N){
        int[] vis = new int[N+1];
        int[] tim = new int[N+1];
        int[] low = new int[N+1];

        int[] isArticulation = new int[N+1];

        int timer = 0;
        for(int i = 0; i<=N; i++){
            if(vis[i]==0)dfs(i, -1, adj, vis, tim, low, timer, isArticulation);
        }
        int ans = 0;
        for(int i=0; i<=N; i++) if(isArticulation[i]==1) ans++;
        System.out.println(ans);
    }

    void dfs(int node, int parent, List<List<Integer>> adj, int[] vis, int[] tim, int[] low, int timer, int[] isArticulation){
        vis[node] = 1;
        tim[node] = low[node] = timer++;
        int child = 0;
        for(Integer it: adj.get(node)){
            if(it == parent) continue;
            if(vis[it]==0){
                dfs(it, node, adj, vis, tim, low, timer, isArticulation);
                low[node] = Math.min(low[it], low[node]);
                if(low[it]>=tim[node] && parent != -1) isArticulation[node] = 1;
                child++;
            }else {
                low[node] = Math.min(tim[it], low[node]);
            }
        }
        if(parent == -1 && child>1) isArticulation[node] = 1;
    }
}