import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int MOD = 1_000_000_000;
    static int n;
    static int r;
    static int m;
    static int k;

    static int[] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static List<Integer>[] list;

    static int count = 0;
    static int[] arr2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int[] dp2 = new int[n + 1];
        dp2[0] = 1;
        dp2[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp2[i] = (dp2[i - 2] + dp2[i / 2]) % MOD;
        }
        System.out.println(dp2[n]);


    }

    private static int recur(int cur, int prev) {
        if (cur < 0) {
            return 0;
        }
        if (cur == 0) {
            return 1;
        }
        if (prev == 0) {
            return dp[cur][0] = 1;
        }
        if (dp[cur][prev] != 0) {
            return dp[cur][prev];
        }
        int tmp = (int) (cur - Math.pow(2, prev));
        if (tmp >= 0) {
            return (dp[cur][prev - 1] = recur(cur, prev - 1) % MOD) + (dp[tmp][prev] = recur(tmp, prev) % MOD);
        }
        return dp[cur][prev] = recur(cur, prev - 1) % MOD;
    }

}