package baekjoon;

import java.util.Scanner;

public class Main9095 {
    private static int result;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            result = 0;
            dfs(n, 0);
            System.out.println(result);

        }
    }

    private static void dfs(int n, int current) {
        if (current == n) {
            result++;
            return;
        }
        if (current > n) {
            return;
        }
        for (int i = 1; i <= 3; i++) {
            dfs(n, current + i);
        }
    }
}