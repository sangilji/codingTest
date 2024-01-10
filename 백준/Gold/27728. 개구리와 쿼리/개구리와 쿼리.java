import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_007;
    static int n;
    static int r;
    static int m;
    static int c;
    static int x;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<int[]>[] list;

    static int count = 0;
    static int[] arr2;
    static int[][] dp;
    static long[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = n - 1; j >= 1; j--) {
                arr[i][j] += arr[i][j + 1];

            }
        }
        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[1][i] = arr[1][i];
            for (int j = 2; j <= n; j++) {
                dp[j][i] = Math.min(arr[j][i], dp[j - 1][i]);
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int tmp = arr[x][y];
            for (int j = y; j <= n; j++) {
                tmp = Math.min(tmp, arr[x][y] - arr[x][j] + dp[x - l][j]);
            }
            sb.append(tmp).append("\n");
        }
        System.out.println(sb);
    }


}