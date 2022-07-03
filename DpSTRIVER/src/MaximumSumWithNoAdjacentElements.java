import java.util.Scanner;

public class MaximumSumWithNoAdjacentElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i =0;i<n;i++)
            ar[i] =  sc.nextInt();
        int ans = new MaximumSumWithNoAdjacentElements().findMaximumSumWithNoAdjacementElements(ar);
        System.out.println(ans);
    }
    int findMaximumSumWithNoAdjacementElements(int ar[])
    {
        int n = ar.length;
        int dp[] = new int[n];
        if(n==1)
            return  ar[0];
        dp[0] = ar[0];
        dp[1] = Math.max(ar[1], dp[0]);

        for(int i =2;i<n;i++)
        {
            dp[i] = ar[i] + dp[i-2];
            dp[i] = Math.max(dp[i], dp[i-1]);
        }
        return  dp[n-1];
    }
}
