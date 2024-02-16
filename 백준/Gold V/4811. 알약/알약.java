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

    static int[] arr;
    static int[] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr1;
    static int count = INF;
    static long[][][] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<int[]>[] list;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = 30;

        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            dp = new long[n * 2][n + 1][n + 1];
            for (int i = 0; i < n * 2; i++) {
                for (int j = 0; j <= n; j++) {
                    Arrays.fill(dp[i][j], -1);
                }
            }
            sb.append(recur(0, n, 0)).append("\n");
        }
        System.out.println(sb);


    }

    private static long recur(int depth, int one, int half) {
        if (half < 0 || one < 0) {
            return 0;
        }
        if (depth == 2 * n) {
            return 1;
        }
        if (dp[depth][one][half] != -1) {
            return dp[depth][one][half];
        }
        return dp[depth][one][half] =
                recur(depth + 1, one - 1, half) + recur(depth + 1, one - 1, half + 1) + recur(depth + 1, one, half - 1);
    }


}