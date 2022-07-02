import java.util.Scanner;

public class FrogJump
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int heights[] = new int[n];
        for(int i =0; i<n;i++)
            heights[i]= sc.nextInt();
        int ans = new FrogJump().minEnergyUsed(heights);
        System.out.println("ans  "+ans);
    }
    int minEnergyUsed(int heights[] )
    {
        int n = heights.length;

        int dp[] = new int[n];
        if(n==1)
            return 0;
        dp[1]  = Math.abs(heights[1] - heights[0]);
        for(int i = 2;i<n;i++) {
            dp[i] = Math.min(dp[i - 2] + Math.abs(heights[i] - heights[i - 2]), dp[i - 1] + Math.abs(heights[i] - heights[i - 1]));
            System.out.println(dp[i]);
        }return dp[n-1];


    }
}
