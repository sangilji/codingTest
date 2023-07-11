import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int[][] dp = new int[n + 1][2];
        if (S.charAt(0) == 'W') {
            dp[0][0]++;
        }
        if (S.charAt(n - 1) == 'E') {
            dp[n - 1][1]++;
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] += dp[i - 1][0];
            if (S.charAt(i) == 'W') {
                dp[i][0]++;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            dp[i][1] += dp[i + 1][1];
            if (S.charAt(i) == 'E') {
                dp[i][1]++;
            }
        }

        long sum = 0;
        for (int i = 1; i < n; i++) {
            if (S.charAt(i) == 'H') {
                long a = dp[i][0];
                if (a == 0) {
                    continue;
                }
                long b = dp[i][1];
                if (b < 2) {
                    continue;
                }

                sum =(sum+ (a * ((pow(2, b) - b - 1) % 1000000007))) % 1000000007;
            }
        }
        System.out.println(sum);
// a  b c   x a b c ab ac bc abc

    }

    private static long pow(int i, long b) {
        if (b == 1) {
            return i;
        }
        long tmp = pow(i, b / 2) % 1000000007;

        if (b % 2 == 0) {
            return ((tmp % 1000000007) * (tmp % 1000000007)) % 1000000007;
        }
        return ((tmp % 1000000007) * (tmp % 1000000007) * i) % 1000000007;
    }
}