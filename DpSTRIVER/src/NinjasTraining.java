import java.util.Scanner;

public class NinjasTraining {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mat[][] = new int[n][3];
        for(int i =0;i<n;i++)
        {
         mat[i][0] =sc.nextInt();
         mat[i][1] = sc.nextInt();
         mat[i][2] = sc.nextInt();

        }
        int ans = ninjaTraining(n, mat);
        System.out.println(ans );
    }
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int dp[][] = new int[n][3];
        dp[0][0] = points[0][0];
        dp[0][1] = points[0][1];
        dp[0][2] = points[0][2];

        for(int i =1;i<n;i++)
        {
            dp[i][0] = points[i][0]+  Math.max(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = points[i][1]+Math.max(dp[i-1][0], dp[i-1][2]);
            dp[i][2] =points[i][2]+ Math.max(dp[i-1][1], dp[i-1][0]);
        }

        return Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2] ));

    }
}
