import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static int[][] dp;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[m][n];
        visit[0][0] = true;
        System.out.println(find(0, 0));
        visit[0][0] = false;

    }

    private static int find(int x, int y) {
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        int tmp = 0;

        for (int i = 0; i < 4; i++) {
            int tx = dx[i] + x;
            int ty = dy[i] + y;
            if (tx < 0 || ty < 0 || tx >= m || ty >= n || visit[tx][ty] || arr[x][y] <= arr[tx][ty]) {
                continue;
            }
            visit[tx][ty] = true;
            tmp += find(tx, ty);
            visit[tx][ty] = false;
        }
        return dp[x][y] = tmp;
    }


}