import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][2];
        dp = new int[n + 100];
        Arrays.fill(dp, -941841);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + arr[i][0]] + arr[i][1]);
        }
        System.out.println(dp[0]);

    }

    private static int find(int depth) {
        if (depth > n) {
            return -1393145;
        }
        if (n == depth) {
            return 0;
        }
        if (dp[depth] != -1) {
            return dp[depth];
        }

        return dp[depth] = Math.max(find(depth + 1), find(depth + arr[depth][0]) + arr[depth][1]);


    }


}