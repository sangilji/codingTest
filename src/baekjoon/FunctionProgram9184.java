package baekjoon;

import java.util.Scanner;

public class FunctionProgram9184 {

    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int a, b, c;
        while (true) {
            a = s.nextInt();
            b = s.nextInt();
            c = s.nextInt();
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(func(a, b, c)).append('\n');
        }
        System.out.println(sb);
    }

    private static int func(int a, int b, int c) {
        if (inRange(a, b, c) && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = func(20, 20, 20);
        }
        if (a < b && b < c) {
            return dp[a][b][c] = func(a, b, c - 1) + func(a, b - 1, c - 1) - func(a, b - 1, c);
        } else {
            return dp[a][b][c] = func(a - 1, b, c) + func(a - 1, b - 1, c) + func(a - 1, b, c - 1) - func(a - 1, b - 1, c - 1);
        }
    }

    private static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && 20 >= b && 0 <= c && 20 >= c;
    }

}
