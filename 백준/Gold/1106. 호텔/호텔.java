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

    static int[][] arr;
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
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] list;
    static List<Integer>[] list2;

    static int[] result;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[m][10000];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(recur(0, 0));
    }

    private static int recur(int depth, int cur) {
        if (depth == m) {
            if (cur < n) {
                return 1231231313;
            }
            return 0;
        }
        if (dp[depth][cur] != -1) {
            return dp[depth][cur];
        }

        int tmp = 1231231313;
        int cost = arr[depth][0];
        int person = arr[depth][1];

        tmp = Math.min(tmp, recur(depth + 1, cur));
        while (true) {
            tmp = Math.min(tmp, recur(depth + 1, cur + person) + cost);
            if (cur + person >= n) {
                break;
            }
            cost += arr[depth][0];
            person += arr[depth][1];
        }
        return dp[depth][cur] = tmp;
    }


}