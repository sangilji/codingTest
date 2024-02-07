import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] coins = new int[n + 1];
        int[] dp = new int[m + 1];
        Arrays.fill(dp, 100000);
        for (int i = 1; i < coins.length; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            if (coins[i] <= m) {
                dp[coins[i]] = 1;
            }
        }

        for (int i = 1; i < m + 1; i++) {
            if (dp[i] == 1) {
                continue;
            }
            for (int j = 1; j < coins.length; j++) {
                if (i - coins[j] > 0 && coins[j] <= m) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        if (dp[m] == 100000) {
            System.out.println(-1);
        } else {
            System.out.println(dp[m]);
        }
    }
}