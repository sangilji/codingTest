import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][2];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(recur(1, 1));
     

    }

    private static long recur(int depth, int current) {
        if (depth == n) {
            return 1;
        }
        if (dp[depth][current] != -1) {
            return dp[depth][current];
        }
        long tmp = 0;
        if (current != 1) {
            tmp += recur(depth + 1, 1);
        }
        tmp += recur(depth + 1, 0);
        return dp[depth][current] = tmp;
    }


}