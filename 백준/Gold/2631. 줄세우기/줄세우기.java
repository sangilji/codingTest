import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static long[] tree;
    static int[] dp;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        arr[0] = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(n - Arrays.stream(dp).max().getAsInt());

    }


}