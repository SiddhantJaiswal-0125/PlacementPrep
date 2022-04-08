import java.util.*;

public class NetworkDelay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noV = sc.nextInt();
        int noE = sc.nextInt();

        int edges[][] = new int[noE][3];
//        double succ[] = new double[noE];
        for(int i =0;i<noE;i++) {

            edges[i][0] = sc.nextInt();
            edges[i][1]= sc.nextInt();
            edges[i][2] = sc.nextInt();

        }
//        System.out.println("ENTER WT");

//        System.out.println("Enter Start and End");
        int start = sc.nextInt();

        int ans = new Solution().networkDelayTime(edges, noV, start);
        System.out.println(ans);


    }

static  class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int dis[] =  new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for(int i =0;i<n;i++)
            adj.add(new ArrayList<>());

        int edges = times.length;
        for(int i =0;i<edges;i++)
            adj.get(times[i][0]-1).add(new Edge(times[i][1]-1, times[i][2]));

//        System.out.println(adj);
        k = k-1;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(k, 0));
        dis[k] = 0;
        boolean vis[] = new boolean[n];

        while(pq.size() > 0)
        {

            Edge p = pq.remove();
            if(vis[p.vert])
                continue;

            vis[p.vert]  = true;
//            System.out.println("P VERT "+p.vert);

            for(Edge e : adj.get(p.vert))
            {
                if(vis[e.vert])
                    continue;

                dis[e.vert] = Math.min(dis[e.vert], dis[p.vert]+ e.wt);
//                System.out.println("DIS "+e.vert + " : "+dis[e.vert]);
                pq.add(new Edge(e.vert, dis[e.vert]));
            }

        }

        int max = -1;
        for(int i =0;i<n;i++)
            if(dis[i] == Integer.MAX_VALUE)
                return -1;
            else
                max = Math.max(dis[i], max);
        return max;

    }
    static class Edge implements Comparable <Edge>
    {
        int vert, wt;
        Edge(int v, int w)
        {
            vert = v;
            wt = w;
        }
        public int compareTo(Edge oth)
        {
            if(this.wt < oth.wt )
                return -1;
            return 1;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "vert=" + vert +
                    ", wt=" + wt +
                    '}';
        }
    }


}
}
