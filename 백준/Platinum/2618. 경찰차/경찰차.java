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
    static int[] arr1;
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

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[m + 2][2];
        arr1 = new int[m + 2];

        dp = new int[m + 2][m + 2];
        for (int i = 0; i < m + 2; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 2; i <= m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        arr[0][0] = 1;
        arr[1][0] = n;
        arr[0][1] = 1;
        arr[1][1] = n;
        sb.append(recur(0, 1)).append("\n");
        getPath(0, 1);
        System.out.println(sb);

    }

    private static int recur(int a, int b) {
        if (a == m + 1 || b == m + 1) {
            return dp[a][b] = 0;
        }

        if (dp[a][b] != -1) {
            return dp[a][b];
        }
        int tmp = INF;
        int next = Math.max(a, b) + 1;
        int tmp2 = recur(next, b) + Math.abs(arr[a][0] - arr[next][0]) + Math.abs(arr[a][1] - arr[next][1]);
        if (tmp > tmp2) {
            tmp = tmp2;
        }
        tmp2 = recur(a, next) + Math.abs(arr[b][0] - arr[next][0]) + Math.abs(arr[b][1] - arr[next][1]);
        if (tmp > tmp2) {
            tmp = tmp2;
        }
        dp[a][b] = tmp;

        return tmp;
    }

    static void getPath(int a, int b) {
        if (a == m + 1 || b == m + 1) {
            return;
        }

        int next = Math.max(a, b) + 1;
        int dist1, dist2;

        if (a == 0) {
            dist1 = getDist(1, 1, arr[next][0], arr[next][1]);
        } else {
            dist1 = getDist(arr[a][0], arr[a][1], arr[next][0], arr[next][1]);
        }

        if (b == 1) {
            dist2 = getDist(n, n, arr[next][0], arr[next][1]);
        } else {
            dist2 = getDist(arr[b][0], arr[b][1], arr[next][0], arr[next][1]);
        }

        if (dp[next][b] + dist1 < dp[a][next] + dist2) {
            sb.append("1\n");
            getPath(next, b);
        } else {
            sb.append("2\n");
            getPath(a, next);
        }
    }

    static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }


}
