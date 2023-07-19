import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n][2];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1][0] == 0) {
                dp[i][0] = arr[i - 1];
            } else {
                dp[i][0] = gcd(dp[i - 1][0], arr[i - 1]);
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (dp[i + 1][1] == 0) {
                dp[i][1] = arr[i + 1];
            } else {
                dp[i][1] = gcd(dp[i + 1][1], arr[i + 1]);
            }
        }
        int max = -1;
        int value = -1;
        for (int i = 0; i < n; i++) {
            int gcd = gcd(dp[i][0], dp[i][1]);
            if (arr[i] % gcd == 0) {
                continue;
            }
            if (max < gcd) {
                max = gcd;
                value = arr[i];
            }
        }
        if (max != -1) {
            System.out.println(max + " " + value);
        } else {
            System.out.println(-1);
        }
    }

    private static int gcd(int a, int b) {
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if (a == 0) {
            return b;
        }
        while (true) {
            if (b % a == 0) {
                return a;
            }
            b = b % a;
            int tmp = a;
            a = b;
            b = tmp;
        }
    }


}