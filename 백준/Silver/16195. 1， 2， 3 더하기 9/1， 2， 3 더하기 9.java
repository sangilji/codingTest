import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_009;
    static int n;
    static int m;
    static int k;

    static int[] arr;
    static int[] visit;
    static int[] dx = {1, 0, 1, 1};
    static int[] dy = {1, 1, 0, -1};
    static int[][] arr1;
    static int count = 0;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            dp = new int[n][m + 1];
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[j], -1);
            }
            sb.append(recur(0, 0)).append("\n");
        }
        System.out.println(sb);
    }

    private static int recur(int depth, int cur) {
        if (cur > m || depth > n) {
            return 0;
        }
        if (depth == n) {
            return 1;
        }
        if (dp[depth][cur] != -1) {
            return dp[depth][cur];
        }
        int tmp = 0;
        for (int i = 1; i <= 3; i++) {
            tmp += recur(depth + i, cur + 1);
            tmp %= MOD;
        }
        return dp[depth][cur] = tmp;
    }


}