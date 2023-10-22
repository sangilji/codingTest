import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static int[] visit;
    static long[] tree;
    static int[][] dp;
    static int[] dx = {1, 0, 1};
    static int[] dy = {0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(recur(1, 1));

    }


    private static int recur(int x, int y) {

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        int count = arr[x][y];
        for (int i = 0; i < 3; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (tx <= 0 || ty <= 0 || tx > n || ty > m) {
                continue;
            }
            count = Math.max(count, recur(tx, ty) + arr[x][y]);
        }
        return dp[x][y] = count;
    }


}