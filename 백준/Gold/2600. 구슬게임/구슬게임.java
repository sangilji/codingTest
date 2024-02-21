import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_009;
    static int n;
    static int m;
    static int k;

    static int[] arr;
    static int[][] sum;
    static int[] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr1;
    static int count = 0;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<int[]>[] list;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[501][501];
        for (int i = 0; i <= 500; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (recur(a, b)) {
                sb.append("A\n");
            } else {
                sb.append("B\n");
            }
        }
        System.out.println(sb);


    }

    private static boolean recur(int a, int b) {
        if (a < 0 || b < 0) {
            return true;
        }
        if (a == 0 && b == 0) {
            return false;
        }
        if (dp[a][b] != -1) {
            return dp[a][b] == 1;
        }
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (!recur(a - arr[i], b)) {
                count++;
            }
            if (!recur(a, b - arr[i])) {
                count++;
            }
        }
        if (count > 0) {
            dp[a][b] = 1;
        } else {
            dp[a][b] = 0;
        }
        return count > 0;
    }


}