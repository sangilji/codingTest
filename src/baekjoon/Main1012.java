package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1012 {
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static boolean[][] visit;
    private static int[][] map;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int m = s.nextInt();
            int n = s.nextInt();
            int k = s.nextInt();
            visit = new boolean[n][m];
            map = new int[n][m];
            for (int j = 0; j < k; j++) {
                int y = s.nextInt();
                int x = s.nextInt();
                map[x][y] = 1;

            }
            System.out.println(bfs());
        }
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    count++;
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] tmp = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int x = dx[k] + tmp[0];
                            int y = dy[k] + tmp[1];
                            if (x < 0 || y < 0 || x >= map.length || y >= map[0].length || map[x][y] == 0
                                    || visit[x][y]) {
                                continue;
                            }
                            visit[x][y] = true;
                            q.add(new int[]{x, y});
                        }
                    }
                }
            }
        }
        return count;
    }
}
