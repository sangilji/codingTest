package baekjoon;

import java.util.Scanner;

public class Main11054 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        int[] dp = new int[n];
        int[] dpR = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            dpR[i] = 1;
            for (int j = n - 1; j >= i; j--) {
                if (a[i] > a[j] && dpR[i] < dpR[j] + 1) {
                    dpR[i] = dpR[j] + 1;
                }
            }
            result = Math.max(result, dpR[i] + dp[i]);
        }
        System.out.println(result - 1);
    }
}
