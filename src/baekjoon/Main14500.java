package baekjoon;

import java.util.Scanner;

public class Main14500 {

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int[][] map;
    private static boolean[][] visit;
    private static int n;
    private static int m;
    private static int max = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = s.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visit[i][j] = false;
                makePurple(0, i, j, 1, map[i][j]);
            }
        }
        System.out.println(max);
    }

    private static void makePurple(int start, int x, int y, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = start; i < 4; i++) {
            int tx = dx[i] + x;
            int ty = dy[i] + y;
            if (tx < 0 || tx >= n || ty < 0 || ty >= m || visit[tx][ty]) {
                continue;
            }
            makePurple(i + 1, x, y, depth + 1, sum + map[tx][ty]);
        }
    }

    private static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int tx = dx[i] + x;
            int ty = dy[i] + y;
            if (tx < 0 || tx >= n || ty < 0 || ty >= m || visit[tx][ty]) {
                continue;
            }
            visit[tx][ty] = true;
            dfs(tx, ty, depth + 1, sum + map[tx][ty]);
            visit[tx][ty] = false;

        }
    }
}
