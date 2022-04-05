import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class BuildAgraph
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Graph gh = new Graph(n);
        int edg = sc.nextInt();
        for(int i =0;i<edg;i++)
        {
            int sr = sc.nextInt();
            int des = sc.nextInt();
            gh.add(sr,des);
        }
//        System.out.println(gh.adj);
        dfs(gh.adj, 1, new boolean[gh.size()]);
    }
  static   void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean vis[])
    {
        System.out.print(src+"\t");
        vis[src]= true;
        for(int i: adj.get(src))
            if(vis[i] == false)
                dfs(adj, i, vis);
    }
}

class Graph
{
    ArrayList<ArrayList<Integer>> adj;
    Graph(int n)
    {
        adj= new ArrayList<>();
        for(int i =0;i<n;i++)
            adj.add(new ArrayList<>());
    }
    void add(int src, int des)
    {
        adj.get(src).add(des);
    }
    int size()
    {
        return  adj.size();
    }



}
