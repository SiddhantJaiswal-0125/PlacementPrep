import java.util.*;

public class pathWithMAXPROB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noV = sc.nextInt();
        int noE = sc.nextInt();

        int edges[][] = new int[noE][2];
        double succ[] = new double[noE];
        for(int i =0;i<noE;i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1]= sc.nextInt();
        }
//        System.out.println("ENTER WT");
        for(int i =0;i<noE;i++)
            succ[i] = sc.nextDouble();

//        System.out.println("Enter Start and End");
        int start = sc.nextInt();
        int end = sc.nextInt();
        double ans = new Solution().maxProbability(noV, edges, succ, start, end);
        System.out.println(ans);


    }
static class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Set<Integer> vis = new HashSet<>();
//      src ->  sare nodes ka max. distance rakhega

        double dis[] = new double[n];

        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for(int i =0;i<n;i++)
            adj.add(new ArrayList<Edge>());

        for(int i =0;i<edges.length; i++)
        {
            adj.get(edges[i][1]).add(new Edge(edges[i][0], succProb[i]));
            adj.get(edges[i][0]).add(new Edge(edges[i][1], succProb[i]));
        }


        Arrays.fill(dis, -1);

        dis[start] = 1;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 1));
        while( pq.isEmpty()== false ) // just for checking to visit all nodes from src
        {
            Edge p = pq.remove();
            vis.add(p.vert);

            for(Edge e : adj.get(p.vert))
            {
                if(vis.contains(e.vert))
                    continue;

                dis[e.vert] = Math.max(dis[e.vert], e.wt * dis[p.vert]);
                pq.add(new Edge(e.vert, dis[e.vert]));
            }


        }

        return dis[end] == -1 ? 0.0: dis[end];


    }


    static class Edge implements Comparable<Edge>
    {

//        0 ----- > node, wt

        int vert;
        double wt;
        Edge(int v, double w)
        {
            vert = v;
            wt = w;
        }
        public int compareTo(Edge oth )
        {
            if(this.wt > oth.wt)
                return -1;
            return 1;
        }
    }
}
}


//3
//        3
//        0
//        1
//        1
//        2
//        0
//        2
//        0.5
//        0.5
//        0.2
//        0
//        2