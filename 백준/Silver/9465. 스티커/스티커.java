import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int MOD = 1000000000;
    static int n;
    static int r;
    static int m;

    static int[][] arr;


    static int count = 0;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[3][n + 1];
            dp = new int[n + 1][3];
            for (int j = 0; j < n + 1; j++) {
                Arrays.fill(dp[j], -1);
            }
            for (int j = 1; j <= 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());

                }
            }
            sb.append(recur(0, 0)).append("\n");
        }
        System.out.println(sb);


    }

    private static int recur(int depth, int cur) {

        if (depth > n) {
            return 0;
        }
        if (dp[depth][cur] != -1) {
            return dp[depth][cur];
        }
        int max = 0;
        if (cur != 1) {
            max = Math.max(max, recur(depth + 1, 1) + arr[1][depth]);
        }

        if (cur != 2) {
            max = Math.max(max, recur(depth + 1, 2) + arr[2][depth]);
        }
        max = Math.max(max, recur(depth + 1, 0));
        return dp[depth][cur] = max;
    }


}