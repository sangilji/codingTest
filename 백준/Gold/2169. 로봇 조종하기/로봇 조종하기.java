import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int INF = 1_000_000_000;
    static int n;
    static int m;
    static int str;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][][] dp;
    static List<int[]>[] list;
    static int[][] visit;
    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new int[n + 2][m + 2];

        visit[1][1] = 1;
        dp = new int[n + 2][m + 2][4];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(dp[i][j], -1);

            }
        }
        System.out.println(recur(1, 1, 0));


    }

    private static int recur(int x, int y,int pos) {
        if (x == n && y == m) {
            return arr[x][y];
        }
        int tmp = -INF;
        if (dp[x][y][pos] != -1) {
            return dp[x][y][pos];
        }

        for (int i = 1; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (tx <= 0 || tx > n || ty <= 0 || ty > m || visit[tx][ty] == 1) {
                continue;
            }
            visit[tx][ty] = 1;
            tmp = Math.max(tmp, recur(tx, ty,i) + arr[x][y]);
            visit[tx][ty] = 0;
        }
        return dp[x][y][pos] = tmp;
    }

}
/*
3 3
20 20 -100
-20 0 100
20 20 20

5 5
-100 -100 -100 -100 -100
-100 -100 -100 -100 -100
-100 -100 -100 -100 -100
-100 -100 -100 -100 -100
-100 -100 -100 -100 -100
 */