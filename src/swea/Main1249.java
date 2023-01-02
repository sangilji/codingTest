package swea;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1249 {
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                String input = sc.next();
                for (int j = 0; j < n; j++) {
                    map[i][j] = input.charAt(j) - '0';
                }
            }
            bfs(map, n, test_case);
        }
    }

    private static void bfs(int[][] map, int n, int test_case) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        q.add(new int[]{0, 0, 0});
        boolean[][] visit = new boolean[n][n];
        visit[0][0] = true;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[0] == n - 1 && tmp[1] == n - 1) {
                System.out.printf("#%d %d\n", test_case, tmp[2]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int x = tmp[0] + dx[i];
                int y = tmp[1] + dy[i];
                if (x < 0 || y < 0 || x >= n || y >= n || visit[x][y]) {
                    continue;
                }
                visit[x][y] = true;
                q.add(new int[]{x, y, tmp[2] + map[x][y]});
            }
        }
    }
}
