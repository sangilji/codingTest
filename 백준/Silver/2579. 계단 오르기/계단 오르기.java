import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int MOD = 1000000000;
    static int n;
    static int r;
    static int m;

    static int[] arr;


    static int count = 0;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[n + 1][4];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(recur(0, 0));
    }

    private static int recur(int depth, int count) {
        if (count == 3 || depth > n) {
            return -123123123;
        }
        if (depth == n) {
            return arr[depth];
        }
        if (dp[depth][count] != -1) {
            return dp[depth][count];
        }
        dp[depth][count] = Math.max(recur(depth + 1, count + 1), recur(depth + 2, 1)) + arr[depth];
        return dp[depth][count];
    }


}