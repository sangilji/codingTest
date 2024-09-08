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
    static int[] arr2;
    static int[] tree;
    static double sum;
    static int[][] visit;
    static int[] visit2;
    static int[] parent;
    static int[] size;
    static int[] min;
    static int[] max;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
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
    static int result = INF;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 2];
        dp = new int[n + 2][4];
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(dp[i], -1);

        }
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(recur(0, 0));


    }

    private static int recur(int depth, int count) {
        if (count == 3) {
            return -123131231;
        }
        if (depth > n) {
            return -123131231;
        }
        if (depth == n) {
            return arr[depth];
        }
        if (dp[depth][count] != -1) {
            return dp[depth][count];
        }
        int tmp = Math.max(recur(depth + 1, count + 1), recur(depth + 2, 1)) + arr[depth];
        return dp[depth][count] = tmp;
    }

}