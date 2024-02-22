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
    static int[] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<int[]>[] list;
    static int[] result;
    static int min = INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        arr = new int[n + 1];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(dp, INF);
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                arr[j] += arr[j - 1];
            }
            int tmp = recur(n);
            if (tmp < 0) {
                sb.append("A\n");
            } else if (tmp > 0) {
                sb.append("B\n");
            } else {
                sb.append("D\n");
            }
        }
        System.out.println(sb);
    }

    private static int recur(int depth) {
            if (dp[depth] != INF) {
            return dp[depth];
        }
        if (depth == 0) {
            return 0;
        }
    

        int tmp = INF;
        for (int i = 0; i < depth; i++) {
            tmp = Math.min(tmp, (arr[depth] - arr[i]) - recur(i));
        }
        return dp[depth] = tmp;

    }


}