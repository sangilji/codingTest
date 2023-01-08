package baekjoon;

import java.util.Scanner;

public class Main17626 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] dp = new int[50001];
        dp[1] = 1;
        int n = s.nextInt();
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        System.out.println(dp[n]);
    }
}
