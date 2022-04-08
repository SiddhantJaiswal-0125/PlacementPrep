
import java.util.*;
class MaxSpanningTree {
    public static void main(String args[] ) throws Exception {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int ind[] = new int[n+1];
            PriorityQueue<node> pq = new PriorityQueue<>();
            for(int i =0;i<m;i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int wt = sc.nextInt();
                ind[u]++;
                ind[v]++;
                pq.add(new node(u,v,wt));
            }
            int dif = m - (n-1);
            long total = 0l;

            for(int i =0;i<dif;)
            {
                node rem = pq.remove();
                if(ind[rem.v]>1 && ind[rem.u] > 1)
                {
                    ind[rem.u]--;
                    ind[rem.v]--;
                    i++;
                }
                else
                    total+= rem.wt;
            }

            while(pq.size() > 0)
                total+= pq.remove().wt;


            System.out.println(total);

        }
    }
    static class node implements Comparable<node>
    {
        int u, v, wt;
        node(int a, int b, int c)
        {
            u = a;
            v = b;
            wt = c;
        }
        public int compareTo(node oth)
        {
            return  this.wt - oth.wt  ;
        }
    }
}
