package baekjoon;

import java.util.Scanner;

public class Main1987 {
    private static int r;
    private static int c;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static boolean[] visit = new boolean[26];
    private static int max = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        r = s.nextInt();
        c = s.nextInt();
        char[][] map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = s.next().toCharArray();
        }
        visit[map[0][0] - 'A'] = true;
        bfs(map, new Position(0, 0), 1);

        System.out.println(max);
    }

    private static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(char[][] map, Position tmp, int depth) {
        for (int i = 0; i < 4; i++) {
            int x = tmp.x + dx[i];
            int y = tmp.y + dy[i];
            if (x < 0 || y < 0 || x >= r || y >= c || visit[map[x][y] - 'A']) {
                continue;
            }
            visit[map[x][y] - 'A'] = true;
            bfs(map, new Position(x, y), depth + 1);
            visit[map[x][y] - 'A'] = false;
        }
        max = Math.max(depth, max);
    }


}
