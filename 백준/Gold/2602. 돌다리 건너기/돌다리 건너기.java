import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int INF = 1_000_000_000;
    static String n;
    static String m;
    static String str;
    static char[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][][] dp;
    static List<int[]>[] list;
    static int[][] visit;
    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = br.readLine();
        arr = new char[2][];
        for (int i = 0; i < 2; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        dp = new int[arr[0].length][2][n.length()];
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        for (int i = 0; i < 2; i++) {
            count += recur(0, i, 0);
        }
        System.out.println(count);

    }

    private static int recur(int cur, int floor, int count) {
        if (count == n.length()) {
            return 1;
        }
        if (cur == arr[0].length) {
            return 0;
        }
        if (dp[cur][floor][count] != -1) {
            return dp[cur][floor][count];
        }
        int tmp = 0;
        if (arr[floor][cur] == n.charAt(count)) {
            tmp += recur(cur + 1, floor ^ 1, count + 1);
        }
        tmp += recur(cur + 1, floor, count);

        return dp[cur][floor][count] = tmp;
    }


}