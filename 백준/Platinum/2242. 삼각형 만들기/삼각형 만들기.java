import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_009;
    static int n;
    static int m;
    static int k;

    static int[] arr;
    static double sum;
    static int[] visit;
    static int[] parent;
    static int[] size;
    static int[] min;
    static int[] max;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr1;
    static int count = 0;
    static long[][][] dp;
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] list;
    static List<Integer>[] list2;

    static int[] result;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        dp = new long[n][n * 20][n * 20];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 20; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        s = sum / 2;
        System.out.println(recur(0, 0, 0));

    }

    static double s;

    private static long recur(int depth, int a, int b) {
        if (depth == n) {
            long c = (long) (sum - a - b);
            if (a == 0 || b == 0 || c == 0) {
                return -1;
            }
            long tmp = (long) Math.floor(Math.sqrt(s * (s - a) * (s - b) * (s - c)) * 100);
            return tmp;
        }
        if (a >= n * 20 || b >= n * 20) {
            return -1;
        }
        if (dp[depth][a][b] != -1) {
            return dp[depth][a][b];
        }
        long tmp = 0;
        tmp = Math.max(tmp, recur(depth + 1, a + arr[depth], b));
        tmp = Math.max(tmp, recur(depth + 1, a, b + arr[depth]));
        tmp = Math.max(tmp, recur(depth + 1, a, b));
        return dp[depth][a][b] = tmp;
    }


}