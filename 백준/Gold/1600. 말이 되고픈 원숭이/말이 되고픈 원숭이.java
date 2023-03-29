import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int h;
    static int w;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] horseX = {2, 2, 1, 1, -1, -1, -2, -2};
    static int[] horseY = {1, -1, 2, -2, 2, -2, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int INF = 987654321;
        int[][][] dp = new int[h][w][k + 1];
        for (int m = k; m >= 0; m--) {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    dp[i][j][m] = INF;
                }
            }
        }
        Queue<int[]> q = new ArrayDeque<>();
        dp[0][0][k] = 0;
        q.add(new int[]{0, 0, k});
        while (!q.isEmpty()) {
            int[] qp = q.poll();
            int i = qp[0];
            int j = qp[1];
            int m = qp[2];
            int tmp = dp[i][j][m] + 1;
            for (int l = 0; l < 4; l++) {
                int x = dx[l] + i;
                int y = dy[l] + j;
                if (x < 0 || y < 0 || x >= h || y >= w || map[x][y] == 1) {
                    continue;
                }
                if (dp[x][y][m] > tmp) {
                    dp[x][y][m] = tmp;
                    q.add(new int[]{x, y, m});
                }
            }

            if (m > 0) {
                for (int l = 0; l < 8; l++) {
                    int x = horseX[l] + i;
                    int y = horseY[l] + j;
                    if (x < 0 || y < 0 || x >= h || y >= w || map[x][y] == 1) {
                        continue;
                    }
                    if (dp[x][y][m - 1] > tmp) {
                        dp[x][y][m - 1] = tmp;
                        q.add(new int[]{x, y, m - 1});
                    }
                }
            }
        }
//        for (int m = k; m >= 0; m--) {
//            for (int i = 0; i < h; i++) {
//                for (int j = 0; j < w; j++) {
//                    int tmp = dp[i][j][m];
//                    if (tmp == INF) {
//                        continue;
//                    }
//                    tmp++;
//
//                    for (int l = 0; l < 4; l++) {
//                        int x = dx[l] + i;
//                        int y = dy[l] + j;
//                        if (x < 0 || y < 0 || x >= h || y >= w || map[x][y] == 1) {
//                            continue;
//                        }
//                        if (dp[x][y][m] > tmp) {
//                            dp[x][y][m] = tmp;
//                        }
//                    }
//
//                    if (m > 0) {
//                        for (int l = 0; l < 8; l++) {
//                            int x = horseX[l] + i;
//                            int y = horseY[l] + j;
//                            if (x < 0 || y < 0 || x >= h || y >= w || map[x][y] == 1) {
//                                continue;
//                            }
//                            if (dp[x][y][m - 1] > tmp) {
//                                dp[x][y][m - 1] = tmp;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        for (int l = k; l >= 0; l--) {
//            for (int i = 0; i < h; i++) {
//                for (int j = 0; j < w; j++) {
//                    System.out.print(dp[i][j][l] == INF ? 0 + " " : dp[i][j][l] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
        int result = INF;
        for (int i = 0; i <= k; i++) {
            result = Math.min(dp[h - 1][w - 1][i], result);
        }
        if (result == INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }


}