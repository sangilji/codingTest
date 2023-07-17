import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new int[n + 1][m + 2];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);

        }

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(find(0, 0));
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
    }

    private static int find(int depth, int current) {
        if (current > m +1) {
            return 914819442;
        }

        if (depth == n) {
            return 0;
        }

        if (dp[depth][current] != -1) {
            return dp[depth][current];
        }

        return dp[depth][current] = Math.min((int) (find(depth + 1, arr[depth] + 1) + Math.pow(m - current + 1, 2)),
                find(depth + 1, arr[depth] + current + 1));
    }


}