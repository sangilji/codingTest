import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1_000_000_000;
    static int n;
    static int m;
    static List<Integer>[] list;
    static int[] parent;
    static int[] score;
    static int[] cards;
    static int[][] arr;
    static int[][][] dp;
    static int[] sz;
    static int[] visit;
    static long count;

    static int a;
    static int b;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(recur(n - 1, 0, 0));
    }

    private static int recur(int x, int y, int pos) {
        if (x < 0 || y < 0 || x >= n || y >= m) {
            return -INF;
        }
        if (x == n - 1 && y == m - 1 && pos == 1) {
            return arr[n - 1][m - 1];
        }
        if (dp[x][y][pos] != -1) {
            return dp[x][y][pos];
        }
        int tmp = -INF;
        if (pos == 0) {
            tmp = Math.max(tmp, recur(x - 1, y, 0) + arr[x][y]);
            tmp = Math.max(tmp, recur(x, y + 1, 0) + arr[x][y]);
            tmp = Math.max(tmp, recur(x, y, 1) + arr[x][y]);

        } else {
            tmp = Math.max(tmp, recur(x + 1, y, 1) + arr[x][y]);
            tmp = Math.max(tmp, recur(x, y + 1, 1) + arr[x][y]);
        }
        return dp[x][y][pos] = tmp;
    }


}