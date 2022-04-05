//Single Source Shortest Path

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class SSSP {
    public static void main(String[] args) {
        Graph gh = new Graph(5);
        gh.add(0,3);
        gh.add(0,1);
        gh.add(1,2);
        gh.add(2,3);
        gh.add(1,4);


        int dis[] = sssp(gh.adj,0);
        for(int i : dis)
            System.out.println(i);

    }
    static  int[]  sssp(ArrayList<ArrayList<Integer>> adj, int src)
    {
        int dis[] = new int[adj.size()];
        boolean vis[] = new boolean[adj.size()];
        vis[src] = true;
        Queue<Integer> q = new ArrayDeque<>();

        Arrays.fill(dis, Integer.MAX_VALUE);
        q.add(src);
        dis[src] =0;
        while (q.size()>0)
        {

            int size = q.size();
            for(int i =0;i<size;i++){
                int poll = q.remove();
                for(int id: adj.get(poll))
                    if(vis[id] == false) {
                        dis[id] = Math.min(dis[id], dis[poll] + 1);
                        q.add(id);

                    }
            }

        }



        return  dis;
    }

}
