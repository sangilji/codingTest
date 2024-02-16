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
    static int[] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr1;
    static int count = INF;
    static int[][][][] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<int[]>[] list;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n][10][10][10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int l = 0; l < 10; l++) {
                    Arrays.fill(dp[i][j][l], -1);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(recur(0, 0, 0, 0));

    }

    private static int recur(int depth, int one, int two, int three) {

        if (depth == n) {
            return 0;
        }
        if (dp[depth][one][two][three] != -1) {
            return dp[depth][one][two][three];
        }
        int tmp = 123123123;
        tmp = Math.min(tmp,
                recur(depth + 1, arr[depth], two, three) + Math.min(Math.abs(one - arr[depth]),
                        10 - Math.max(one, arr[depth]) + Math.min(one, arr[depth])));
        tmp = Math.min(tmp,
                recur(depth + 1, one, arr[depth], three) + Math.min(Math.abs(two - arr[depth]),
                        10 - Math.max(two, arr[depth]) + Math.min(two, arr[depth])));
        tmp = Math.min(tmp,
                recur(depth + 1, one, two, arr[depth]) + Math.min(Math.abs(three - arr[depth]),
                        10 - Math.max(three, arr[depth]) + Math.min(three, arr[depth])));
        return dp[depth][one][two][three] = tmp;
    }

}