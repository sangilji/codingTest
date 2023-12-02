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
    static List<int[]>[] list;
    static int[] parent;
    static int[] score;
    static int[] cards;
    static int[] arr;
    static int[][][] dp;
    static int[] sz;
    static int[] visit;
    static long count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new int[n + 1][3][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(recur(0, 1, m));

    }

    private static int recur(int depth, int cur, int k) {
        if (depth == n) {
            return 0;
        }
        if (dp[depth][cur][k] != -1) {
            return dp[depth][cur][k];
        }
        int tmp = 0;
        if (arr[depth] == cur) {
            tmp = Math.max(tmp, recur(depth + 1, cur, k) + 1);
        }
        if (k > 0 && arr[depth] != cur) {
            tmp = Math.max(tmp, recur(depth + 1, cur == 1 ? 2 : 1, k - 1) + 1);
        }
        tmp = Math.max(tmp, recur(depth + 1, cur, k));

        return dp[depth][cur][k] = tmp;
    }

}