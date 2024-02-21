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

    static int[][] arr;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        if (recur(n)) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }


    }// SK SK SK SK CY

    private static boolean recur(int cur) {
        if (cur < 0) {
            return true;
        }
        if (cur == 0) {
            return false;
        }
        if (dp[cur] != -1) {
            return dp[cur] == 1;
        }
        int count = 0;
        if (!recur(cur - 1)) {
            count++;
        }
        if (!recur(cur - 3)) {
            count++;
        }
        if (!recur(cur - 4)) {
            count++;
        }
        if (count > 0) {
            dp[cur] = 1;
        } else {
            dp[cur] = 0;
        }

        return count > 0;
    }


}