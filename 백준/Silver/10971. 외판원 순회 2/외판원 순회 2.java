import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] dp;
    static int n;
    static final int INF = 11000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][1<<n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }

        System.out.println(dfs(0, 1));

    }

    private static int dfs(int current, int bit) {
        if (bit == (1 << n) - 1) {
            if (map[current][0] == 0) {
                return INF;
            }
            return map[current][0];
        }
        int tmp = dp[current][bit];
        if (tmp != INF) {
            return tmp;
        }

        for (int i = 0; i < n; i++) {
            if (map[current][i] != 0 && (bit & (1 << i)) == 0) {
                dp[current][bit] = Math.min(dp[current][bit], map[current][i] + dfs(i, bit | (1 << i)));
            }
        }
        return dp[current][bit];
    }
}