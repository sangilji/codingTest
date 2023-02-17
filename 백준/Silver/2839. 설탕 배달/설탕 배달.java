import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] dp = new int[n + 1];

        dp[3] = 1;
        if (n >= 5) {
            dp[5] = 1;
        }
        for (int i = 6; i <= n; i++) {
            if (dp[i - 3] != 0) {
                dp[i] = dp[i - 3] + 1;
            }
            if (dp[i - 5] != 0) {
                dp[i] = dp[i - 5] + 1;
            }
        }
        if (dp[n] == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(dp[n]);
    }
}