package swea;

import java.util.Scanner;

public class Main1247 {
    static boolean[] visit;
    static int minValue;
    static int[] home;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            home = new int[2];
            home[0] = sc.nextInt();
            home[1] = sc.nextInt();
            int[][] client = new int[n][2];
            for (int i = 0; i < n; i++) {
                client[i][0] = sc.nextInt();
                client[i][1] = sc.nextInt();
            }
            minValue = 100000;
            visit = new boolean[n];
            dfs(x, y, client, 0, 0);
            System.out.printf("#%d %d\n", test_case, minValue);
        }
    }

    private static void dfs(int x, int y, int[][] client, int depth, int sum) {
        if (depth == client.length) {
            minValue = Math.min(minValue, sum + Math.abs(x - home[0]) + Math.abs(y - home[1]));
        }

        for (int i = 0; i < client.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(client[i][0], client[i][1], client, depth + 1, sum + Math.abs(x - client[i][0]) + Math.abs(y - client[i][1]));
                visit[i] = false;
            }
        }
    }
}
