import java.util.Scanner;

public class ClimbStairs {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();

        int ans = countDistinctWayToClimbStair(n);
        System.out.println(ans);
    }
    public static int countDistinctWayToClimbStair(long n1) {

        int n = (int)(n1);
        int a = 0;
        int b = 1;
        for(int i = 2;i<=n;i++)
        {
            int temp = b;

            b = a+b;
            a = temp;
        }
        return b;
    }
}
