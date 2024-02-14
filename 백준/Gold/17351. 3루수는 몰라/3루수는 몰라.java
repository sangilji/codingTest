import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_009;
    static int n;
    static int m;
    static int k;

    static int[][] arr;
    static int[] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr1;
    static int count = INF;
    static int[][][] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<int[]>[] list;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String tmp = br.readLine();
            for (int j = 1; j <= n; j++) {
                arr[i][j] = tmp.charAt(j - 1);
            }
        }
        dp = new int[n + 1][n + 1][5];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);

            }
        }

        System.out.println(recur(1, 1, arr[1][1] == 'M' ? 1 : 0));


    }

    private static int recur(int x, int y, int count) {
        if (x == n && y == n) {
            if (count == 4) {
                return 1;
            }
            return 0;
        }
        if (dp[x][y][count] != -1) {
            return dp[x][y][count];
        }
        if (arr[x][y] == 'M') {
            count = (count / 4) * 4 + 1;
        }
        int tmp = 0;
        for (int i = 0; i < 2; i++) {
            int tx = dx[i] + x;
            int ty = dy[i] + y;
            if (tx > n || ty > n) {
                continue;
            }
            if (count == 0) {
                tmp = Math.max(tmp, recur(tx, ty, arr[tx][ty] == 'M' ? count + 1 : 0));
            } else if (count % 4 == 1) {
                tmp = Math.max(tmp, recur(tx, ty, arr[tx][ty] == 'O' ? count + 1 : 0));
            } else if (count % 4 == 2) {
                tmp = Math.max(tmp, recur(tx, ty, arr[tx][ty] == 'L' ? count + 1 : 0));
            } else if (arr[tx][ty] == 'A') {
                tmp = Math.max(tmp, recur(tx, ty, 0) + 1);
            } else {
                tmp = Math.max(tmp, recur(tx, ty, 0));
            }
        }
        return dp[x][y][count] = tmp;
    }


}