import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 100_000;
    static int n;
    static int m;
    static int k;

    static int[][] arr;
    static int[] tree;
    static double sum;
    static int[] visit;
    static int[] visit2;
    static int[] parent;
    static int[] size;
    static int[] min;
    static int[] max;
    static int[] dx = {1, -1, 1, -1};
    static int[] dy = {1, 1, -1, -1};
    static int[] arr1;
    static int count = 0;
    static int[][][] dp;
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] list;
    static List<Integer>[] list2;

    static Set<Integer> set = new HashSet<>();
    static int l;
    static int r;
    static int x;
    static char[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][m + 1][5];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(recur(1, 1, 0));

    }

    private static int recur(int x, int y, int status) {
        if (x > n || y > m) {
            return 0;
        }
        if (x == n && y == m) {
            return 1;
        }
        if (dp[x][y][status] != -1) {
            return dp[x][y][status];
        }
        int tmp = 0;
        if (status == 0) {
            tmp += recur(x + 1, y, 3);
            tmp %= MOD;
            tmp += recur(x, y + 1, 4);
            tmp %= MOD;
        }
        if (status == 1) {
            tmp += recur(x + 1, y, 3);
            tmp %= MOD;
        }
        if (status == 2) {
            tmp += recur(x, y + 1, 4);
            tmp %= MOD;
        }
        if (status == 3) {
            tmp += recur(x + 1, y, 3);
            tmp %= MOD;
            tmp += recur(x, y + 1, 2);
            tmp %= MOD;
        }
        if (status == 4) {
            tmp += recur(x + 1, y, 1);
            tmp %= MOD;
            tmp += recur(x, y + 1, 4);
            tmp %= MOD;
        }
        return dp[x][y][status] = tmp;

    }


}