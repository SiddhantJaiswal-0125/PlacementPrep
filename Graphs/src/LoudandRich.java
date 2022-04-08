import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LoudandRich {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int rich[][] = new int[m][2];
        for(int i =0;i<m;i++)
        {
            int  a = sc.nextInt();
            int b = sc.nextInt();
            rich[i][0] = a;
            rich[i][1] = b;
        }
        int w[] = new int[n];
        for(int i =0;i<n;i++)
            w[i] = sc.nextInt();
       int ans[] =  new Solution().loudAndRich(rich, w);
        System.out.println("Answerr is ");

        for(int i : ans)
           System.out.print(i+"\t");
        System.out.println();

    }




}


class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {

        int noE = richer.length;

        int noV = quiet.length;
        Graph gh = new Graph(noV);
        for(int i =0;i<noE;i++)
            gh.add(richer[i][1], richer[i][0]);

        boolean vis[] = new boolean[noV];
        int min[] = new int[noV];
        Arrays.fill(min, Integer.MAX_VALUE);
//        gh.display();

        for(int i =0;i<noV;i++)
            if(vis[i] == false)
                dfs(i, gh, min, vis, quiet);


        return  min;

    }

    int dfs(int sr, Graph gh, int min[], boolean vis[], int quiet[])
    {
        if(vis[sr])
            return min[sr];

        vis[sr] =true;
        int mini =  sr;
        for(int i : gh.adj.get(sr))
        {
            int in = dfs(i, gh, min, vis, quiet);
            if(quiet[in] < quiet[mini])
                mini = in;

        }
        min[sr] = mini;
        return mini;
    }

    static class Graph
    {
        ArrayList<ArrayList<Integer>> adj;
        Graph(int n)
        {
            adj= new ArrayList<>();
            for(int i =0;i<n;i++)
                adj.add(new ArrayList<>());
//            double p[] = new double[5];
//            Arrays.fill(p, Double.MAX_VALUE);
        }
        void add(int src, int des)
        {
            adj.get(src).add(des);
        }
        int size()
        {
            return  adj.size();
        }

        void  display()
        {
            System.out.println(adj);
        }

    }

    static class pair implements Comparable<pair>
    {

        public int compareTo(pair p)
        {
            return 0;
        }


    }}



//8
//        7
//        1
//        0
//        2
//        1
//        3
//        1
//        3
//        7
//        4
//        3
//        5
//        3
//        6
//        3
//        3
//        2
//        5
//        4
//        6
//        1
//        7
//        0
