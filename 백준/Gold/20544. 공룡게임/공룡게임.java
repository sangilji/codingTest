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
    static int MOD = 1_000_000_007;
    static int n;
    static int m;
    static int k;

    static int[] arr;
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
    static int[][][][] dp;
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
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][3][5][2];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 3; j++) {
                for (int o = 0; o < 5; o++) {
                    Arrays.fill(dp[i][j][o], -1);
                }
            }
        }
        System.out.println(recur(1, 0, 0, 0));

    }

    private static int recur(int cur, int prev, int high, int flag) {
        if (high >= 4) {
            return 0;
        }

        if (cur == n) {
            if (flag == 0) {
                return 0;
            }
            return 1;
        }
        if (dp[cur][prev][high][flag] != -1) {
            return dp[cur][prev][high][flag];
        }
        int tmp = 0;
        if (prev == 2) {
            tmp += recur(cur + 1, 0, 0, flag);
            tmp %= MOD;
            return dp[cur][prev][high][flag] = tmp;
        }
        tmp += recur(cur + 1, 0, 0, flag);
        tmp %= MOD;
        tmp += recur(cur + 1, prev + 1, high + 1, flag);
        tmp %= MOD;
        tmp += recur(cur + 1, prev + 1, high + 2, flag | 1);
        tmp %= MOD;
        return dp[cur][prev][high][flag] = tmp;
    }

}