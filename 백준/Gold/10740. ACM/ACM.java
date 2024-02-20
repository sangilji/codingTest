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
    static int[][] sum;
    static int[] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr1;
    static int count = 0;
    static int[][][] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<int[]>[] list;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[3][n];
        sum = new int[3][n + 1];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j + 1] = sum[i][j] + arr[i][j];
            }
        }
        dp = new int[n][3][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int l = 0; l < 3; l++) {
                    Arrays.fill(dp[i][j], -1);
                }
            }
        }

        int result = INF;
        for (int i = 0; i < 3; i++) {
            result = Math.min(recur(0, i, i), result);
        }
        System.out.println(result);

    }

    private static int recur(int depth, int prev, int cur) {
        if (depth == n) {
            return 0;
        }
        if (dp[depth][prev][cur] != -1) {
            return dp[depth][prev][cur];
        }
        int tmp = INF;
        if (prev == cur) {
            if (depth < n - 3) {
                tmp = Math.min(tmp, recur(depth + 1, prev, cur));
            }
            for (int i = 0; i < 3; i++) {
                if (i != cur) {
                    tmp = Math.min(tmp, recur(depth + 1, cur, i));
                }
            }
        } else {
            if (depth < n - 2) {
                tmp = Math.min(recur(depth + 1, prev, cur), tmp);
            }
            for (int i = 0; i < 3; i++) {
                if (i != cur && i != prev) {
                    tmp = Math.min(tmp, sum[i][n] - sum[i][depth + 1]);
                }
            }
        }
        tmp += arr[cur][depth];
        return dp[depth][prev][cur] = tmp;

    }


}