package baekjoon;

import java.util.Scanner;

public class Main9251 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = " " + s.next();
        String b = " " + s.next();
        int[][] dp = new int[a.length()][b.length()];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {

                if (a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        System.out.println(dp[dp.length - 1][dp[0].length - 1]);
    }
}
