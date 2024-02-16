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
    static int[] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr1;
    static int count = INF;
    static int[][] dp;
    static int[][] dp2;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<int[]>[] list;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[n][3];
        dp2 = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            Arrays.fill(dp2[i], -1);
        }
        System.out.println(recur(0, 1) + " " + recur2(0, 1));


    }

    private static int recur2(int depth, int prev) {
        if (depth == n) {
            return 0;
        }
        if (dp2[depth][prev] != -1) {
            return dp2[depth][prev];
        }
        int tmp = 123123123;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(prev - i) <= 1) {
                tmp = Math.min(tmp, recur2(depth + 1, i) + arr[depth][i]);
            }
        }
        return dp2[depth][prev] = tmp;
    }

    private static int recur(int depth, int prev) {
        if (depth == n) {
            return 0;
        }
        if (dp[depth][prev] != -1) {
            return dp[depth][prev];
        }
        int tmp = 0;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(prev - i) <= 1) {
                tmp = Math.max(tmp, recur(depth + 1, i) + arr[depth][i]);
            }
        }
        return dp[depth][prev] = tmp;

    }


}