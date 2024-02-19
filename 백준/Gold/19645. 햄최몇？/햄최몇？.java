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
        arr = new int[n];
        dp = new int[n][n * 50][n * 50];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 50; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            count += arr[i];
        }
        System.out.println(recur(0, 0, 0));
    }

    private static int recur(int depth, int a, int b) {
        if (depth == n) {
            int c = count - (a + b);
            if (c > a || c > b) {
                return -112312312;
            }
            return c;
        }
        if (dp[depth][a][b] != -1) {
            return dp[depth][a][b];
        }
        int tmp = 0;
        tmp = Math.max(tmp, recur(depth + 1, a + arr[depth], b));
        tmp = Math.max(tmp, recur(depth + 1, a, b + arr[depth]));
        tmp = Math.max(tmp, recur(depth + 1, a, b));

        return dp[depth][a][b] = tmp;
    }


}