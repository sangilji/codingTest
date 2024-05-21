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
    static int MOD = 100_000;
    static int n;
    static int m;
    static int k;

    static int[] arr;
    static int[] tree;
    static double sum;
    static int[] visit;
    static int[] visit2;
    static int[] parent;
    static int[] size;
    static int[] min;
    static int[] max;
    static int[] dx = {1, -1, 1, -1};
    static int[] dy = {1, 1, -1, -1};
    static int[] arr1;
    static int count = 0;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] list;
    static List<Integer>[] list2;

    static Set<Integer> set = new HashSet<>();
    static int l;
    static int r;
    static int x;
    static char[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1][3];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = recur(1, 0);
        if (result < 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);

    }

    private static int recur(int cur, int count) {
        if (cur < 1 || cur > n || count > 2) {
            return -INF;
        }
        if (cur == n) {
            return 0;
        }
        if (arr[cur] == 0) {
            return -INF;
        }
        if (dp[cur][count] != -1) {
            return dp[cur][count];
        }
        int tmp = -INF;
        int mul = 1;
        if (count == 1) {
            mul = -1;
        }
        tmp = Math.max(tmp, recur(cur + arr[cur] * mul, count) + 1);
        tmp = Math.max(recur(cur, count + 1), tmp);
        return dp[cur][count] = tmp;

    }


}