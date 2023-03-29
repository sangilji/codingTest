import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[31][31];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            combi(n, m);
           sb.append(dp[n][m]).append("\n");
        }
        System.out.println(sb);
    }

    private static int combi(int n, int m) {
        if (dp[n][m] > 0) {
            return dp[n][m];
        }
        if (n == m || n == 0) {
            return dp[n][m]= 1;
        }
        return dp[n][m] = combi(n, m - 1) + combi(n - 1, m - 1);
    }
}
//    1
//  1 2  1
// 1 3  3   1
//1 4  6  4  1