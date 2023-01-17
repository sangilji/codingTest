import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n+1];
            int[][] dp = new int[2][n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                sticker[0][j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                sticker[1][j] = Integer.parseInt(st.nextToken());
            }
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];
            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j-1],Math.max(dp[0][j-2],dp[1][j-2])) + sticker[0][j];
                dp[1][j] = Math.max(dp[0][j-1],Math.max(dp[0][j-2],dp[1][j-2])) + sticker[1][j];
            }
            System.out.println(Math.max(dp[0][n],dp[1][n]));
        }

    }

}
