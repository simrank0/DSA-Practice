package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class AkbarTheGreat {
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            String[] input= br.readLine().split(" ");
            int N=Integer.parseInt(input[0]);
            int R=Integer.parseInt(input[1]);
            int M=Integer.parseInt(input[2]);
            Map<Integer, Integer> guards= new HashMap<>();
            ArrayList<Integer>[] adj= new ArrayList[N];
            for(int i=0;i<R;++i){
                String[] edge= br.readLine().split(" ");
                int u=Integer.parseInt(edge[0])-1;
                int v= Integer.parseInt(edge[1])-1;
                if(adj[u]==null)
                    adj[u]=new ArrayList<>();
                adj[u].add(v);
                if(adj[v]==null)
                    adj[v]=new ArrayList<>();
                adj[v].add(u);
            }
            for(int i=0;i<M;++i){
                String[] gaurd= br.readLine().split(" ");
                guards.put(Integer.parseInt(gaurd[0])-1,Integer.parseInt(gaurd[1]));
            }
            System.out.println(checkOptimal(N,adj,guards)?"Yes":"No");
        }

    }
    private static boolean checkOptimal(int N,ArrayList<Integer>[] adj,Map<Integer, Integer> gaurds){
        Set<Integer> protect = new HashSet<>();
        //int[] visited= new int[N];
        for(Map.Entry<Integer,Integer> ent:gaurds.entrySet()){
            boolean check=bfs(protect,adj,ent.getKey().intValue(),ent.getValue().intValue());
            if(!check)
                return false;
        }
        if(protect.size()<N)
            return false;

        return true;

    }
    private static boolean bfs(Set<Integer> protect,ArrayList<Integer>[] adj, int start, int cap){
        // if(visited[start]!=0)
        // 	return false;
        //	int count=0;
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{start,0});
        while(!q.isEmpty()){
            int[] curr= q.poll();
            if(protect.contains(curr[0]))
                return false;
            if(visited.contains(curr[0]))
                continue;
            visited.add(curr[0]);
            if(curr[1]==cap)
                continue;
            for(int n:adj[curr[0]]){
                if(!visited.contains(n)){
                    q.offer(new int[]{n,curr[1]+1});
                }


            }

        }
        protect.addAll(visited);
        return true;
    }
}
