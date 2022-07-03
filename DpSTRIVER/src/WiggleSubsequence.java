import java.util.Scanner;

public class WiggleSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[]=  new int[n];
        for(int i = 0 ;i<n ; i++)
            ar[i] = sc.nextInt();
        int ans = new WiggleSubsequence().wiggleMaxLength(ar);
        System.out.println(ans);

    }

    public int wiggleMaxLength(int[] nums) {
        int size = nums.length;
        int dp[][] = new int[2][size];
        dp[0][0] = 1;
        dp[1][0] = 1;
        for(int i= 1; i<size;i++)
        {
            dp[0][i] = dp[0][i-1];
            dp[1][i]=dp[1][i-1];
            for(int j  = 0 ;j<i; j++)
            {
                if(nums[i]== nums[j])
                    continue;
                if(nums[i] - nums[j] < 0) {
                    dp[1][i] = Math.max(dp[1][i], dp[0][j] + 1);
                }else {
                    dp[0][i] = Math.max(dp[0][i], dp[1][j] + 1);
                }
            }
        }

        return Math.max(dp[0][size-1], dp[1][size-1]);

    }
}

//10
//        1
//        17
//        5
//        10
//        13
//        15
//        10
//        5
//        16
//        8