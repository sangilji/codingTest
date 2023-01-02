package baekjoon;

import java.util.Scanner;

public class Main14503 {

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int n;
    private static int m;
    private static int[][] map;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        n = s.nextInt();
        m = s.nextInt();
        map = new int[n][m];
        int r = s.nextInt();
        int c = s.nextInt();
        int d = s.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = s.nextInt();
            }
        }
        System.out.println(bfs(r, c, d));
    }

    private static int bfs(int x, int y, int d) {
        int count = 0;
        boolean b = false;
        while (true) {
            if (map[x][y] == 0) {
                map[x][y] = 2;
                count++;
            }
            for (int i = 0; i < 4; i++) {
                d--;
                if (d < 0) {
                    d = 3;
                }
                int tmpX = dx[d] + x;
                int tmpY = dy[d] + y;
                if (tmpX < 0 || tmpX >= n || tmpY < 0 || tmpY >= m || map[tmpX][tmpY] != 0) {
                    continue;
                }
                x = tmpX;
                y = tmpY;

                b = true;
                break;

            }
            if (b) {
                b = false;
                continue;
            }

            d = (d + 2) % 4;
            int tmpX = dx[d] + x;
            int tmpY = dy[d] + y;
            if (tmpX < 0 || tmpX >= n || tmpY < 0 || tmpY >= m || map[tmpX][tmpY] == 1) {
                break;
            } else {
                x = tmpX;
                y = tmpY;
                d = (d + 2) % 4;
            }
        }
        return count;
    }
}
