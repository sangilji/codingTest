import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] dp;
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[31][15001];
        find(0, 0);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp>15000){
                sb.append("N ");
                continue;
            }
            if (dp[n][tmp]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }
        System.out.println(sb);
    }

    private static void find(int depth, int weight) {
        if (dp[depth][weight]) {
            return;
        }
        dp[depth][weight] = true;
        if (depth == n) {
            return;
        }
        find(depth + 1, weight);
        find(depth + 1, weight + arr[depth]);
        find(depth + 1, Math.abs(weight - arr[depth]));
    }


}