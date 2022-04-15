package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    private static class Node{
        private int v;
        public int w;
        public Node(int a,int b){
            this.v = a;
            this.w = b;
        }

    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> adj = new ArrayList<>();

        int[] dis = new int[n+1];
        for(int i=1;i<=n;i++)dis[i]=Integer.MAX_VALUE;
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());
        for(int[] it: times){
            adj.get(it[0]).add(new Node(it[1],it[2]));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->a.w-b.w);
        pq.offer(new Node(k,0));
        while(!pq.isEmpty()){
            Node qNode = pq.poll();
            if(dis[qNode.v]<Integer.MAX_VALUE)
                continue;
            dis[qNode.v]=qNode.w;
            for(Node it: adj.get(qNode.v)){
                if(dis[it.v]==Integer.MAX_VALUE){

                    pq.offer(new Node(it.v,qNode.w+it.w));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++)
            max = Math.max(max,dis[i]);
        return max==Integer.MAX_VALUE?-1:max;
    }
}
