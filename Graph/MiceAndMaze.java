package Graph;

import java.io.IOException;
import java.util.*;

public class MiceAndMaze {
    public static void main(String[] args) throws IOException
    {
        /* Input */
        Scanner in = new Scanner(System.in);

        int n, e, t, m;
        n = in.nextInt();
        e = in.nextInt();
        t = in.nextInt();
        m = in.nextInt();
        e--;

        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++)
        {
            int a, b, d;
            a = in.nextInt();
            b = in.nextInt();
            d = in.nextInt();
            adjList.get(b-1).add(new Edge(d, a-1));
        }

        in.close();

        /* Processing */
        int numMice = 0;
        List<Integer> dist=minTime(adjList,e);
        for (int i = 0; i < n; i++)
        {
            if (dist.get(i) <= t)
                numMice++;
        }

        /* Output */
        System.out.println(numMice);

    }

    private static List<Integer> minTime(List<List<Edge>> adjList, int start)
    {
        List<Integer> dist = new ArrayList<>(adjList.size());
        for (int i = 0; i < adjList.size(); i++)
        {
            dist.add((int) 1e9);
        }
        dist.set(start, 0);

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt((Edge a) -> a.dist));
        pq.add(new Edge(0, start));

        while (!pq.isEmpty())
        {
            Edge edge = pq.poll();
            int w = edge.dist;
            int i = edge.id;

            // optimizations
            //	if (i == end) return dist.get(end);
            if (w > dist.get(i)) continue;
            dist.set(i,w);

            // loop through connected nodes
            for (Edge otherEdge : adjList.get(i))
            {
                int ow = otherEdge.dist;
                int oi = otherEdge.id;
                if (dist.get(oi)==(int) 1e9)
                {
                    //dist.set(oi, dist.get(i) + ow);
                    pq.add(new Edge(w+ow, oi));
                }
            }
        }

        return dist;
    }

    static class Edge
    {
        int dist;
        int id;

        public Edge(int dist, int id)
        {
            this.dist = dist;
            this.id = id;
        }
    }
}
