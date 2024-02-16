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
    static long[][][] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<int[]>[] list;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        s = br.readLine().split("");
        dp = new long[s.length][s.length][3];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(recur(0, s.length - 1, 0));

    }

    private static long recur(int left, int right, int time) {
        if (left > right) {
            return 0;
        }
        if (dp[left][right][time] != -1) {
            return dp[left][right][time];
        }

        long tmp = 0;
        if (time == 0) {
            if (s[left].equals("B")) {
                tmp = Math.max(tmp, recur(left + 1, right, time + 1) + 1);
            }
            if (s[right].equals("B")) {
                tmp = Math.max(tmp, recur(left, right - 1, time + 1) + 1);
            }
        } else if (time == 1) {
            if (s[left].equals("L")) {
                tmp = Math.max(tmp, recur(left + 1, right, time + 1) + 1);
            }
            if (s[right].equals("L")) {
                tmp = Math.max(tmp, recur(left, right - 1, time + 1) + 1);
            }
        } else {
            if (s[left].equals("D")) {
                tmp = Math.max(tmp, recur(left + 1, right, 0) + 1);
            }
            if (s[right].equals("D")) {
                tmp = Math.max(tmp, recur(left, right - 1, 0) + 1);
            }
        }
        return dp[left][right][time] = tmp;
    }


}