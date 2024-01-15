import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_007;
    static int MOD = 1_000_000_007;
    static int n;
    static int m;

    static int[][] arr;

    static int[] dx = {1, 0, 1, 1};
    static int[] dy = {1, 1, 0, -1};

    static long count = 0;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[n + 1][n + 1][4][2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        dp[i][j][k][0] = 1;
                        dp[i][j][k][1] = 1;
                    }
                }
                if (arr[i][j] == 2) {
                    for (int k = 0; k < 4; k++) {
                        dp[i][j][k][0] = 1;
                    }
                }
            }
        }
        for (int i = n; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                for (int k = 0; k < 4; k++) {
                    int tx = i + dx[k];
                    int ty = j + dy[k];
                    if (tx <= 0 || ty <= 0 || tx > n || ty > n || arr[tx][ty] == 0) {
                        continue;
                    }
                    if (arr[tx][ty] == 2) {
                        dp[i][j][k][1] += dp[tx][ty][k][0];
                    } else {
                        dp[i][j][k][0] += dp[tx][ty][k][0];
                        dp[i][j][k][1] += dp[tx][ty][k][1];
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 2; l++) {
                        count = Math.max(dp[i][j][k][l], count);
                    }
                }
            }
        }
        System.out.println(count);
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (arr[i][j] == 1) {
//                    for (int k = 0; k < 4; k++) {
//                        count = Math.max(count, recur(i, j, k, 0));
//                    }
//                }
//            }
//        }
//        System.out.println(count);
    }

    private static int recur(int x, int y, int dir, int use) {
        if (x <= 0 || y <= 0 || x > n || y > n || arr[x][y] == 0) {
            return 0;
        }
        if (arr[x][y] == 2) {
            if (use == 1) {
                return 0;
            }
            use = 1;
        }
        if (dp[x][y][dir][use] != -1) {
            return dp[x][y][dir][use];
        }
        return recur(x + dx[dir], y + dy[dir], dir, use) + 1;
    }


}