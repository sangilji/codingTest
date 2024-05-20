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
        arr = new int[n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(recur(0, n - 1));

    }

    private static int recur(int left, int right) {
        if (left >= right) {
            return 0;
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        int tmp = INF;
        if (arr[left] == arr[right]) {
            tmp = Math.min(tmp, recur(left + 1, right - 1));
        } else {
            tmp = Math.min(tmp, recur(left, right - 1) + 1);
            tmp = Math.min(tmp, recur(left + 1, right) + 1);
        }
        return dp[left][right] = tmp;

    }


}