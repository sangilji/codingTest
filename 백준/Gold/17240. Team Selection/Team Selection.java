import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_007;
    static int n;
    static int m;
    static int k;

    static int[][] arr;
    static int[] arr2;
    static int[] costs;
    static int[] visit;
    static int[] visit2;
    static int[] sz;
    static int[] depth;
    static int[] parent;
    static int[] top;
    static int[] in;
    static int[] out;
    static long[] tree_min;
    static long[] tree_max;
    static List<String> list;
    static List<int[]>[] graph;
    static int[] dx = {1, 0, 1, 1};
    static int[] dy = {1, 1, 0, -1};
    static int[][] arr1;
    static int count = 0;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][5];
        dp = new int[n][1 << 5];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(recur(0, 0));

    }

    private static int recur(int depth, int bit) {
        if (depth == n) {
            if (bit != (1 << 5) - 1) {
                return -1231123123;
            }
            return 0;
        }
        if (dp[depth][bit] != -1) {
            return dp[depth][bit];
        }
        int tmp = 0;
        for (int i = 0; i < 5; i++) {
            if (((1 << i) & bit) == 0) {
                tmp = Math.max(tmp, recur(depth + 1, bit | (1 << i)) + arr[depth][i]);
            }
        }
        tmp = Math.max(tmp, recur(depth + 1, bit));
        return dp[depth][bit] = tmp;
    }


}