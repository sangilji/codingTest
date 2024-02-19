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
    static int[][][] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<int[]>[] list;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        dp = new int[n][3][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(recur(0, 0, 0));

    }

    private static int recur(int depth, int l, int a) {
        if (l >= 2 || a >= 3) {
            return 0;
        }
        if (depth == n) {
            return 1;
        }
        if (dp[depth][l][a] != -1) {
            return dp[depth][l][a];
        }
        int tmp = recur(depth + 1, l, 0) + recur(depth + 1, l + 1, 0) + recur(depth + 1, l, a + 1);
        tmp %= 1_000_000;
        return dp[depth][l][a] = tmp;
    }


}