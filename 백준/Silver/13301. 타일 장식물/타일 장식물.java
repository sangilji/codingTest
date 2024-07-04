import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int INF = 1_000_000_000;
    static int n;
    static int m;
    static int k;
    static int str;
    static int[] arr;
    static int[] tree;
    static int[] treeMaxIndex;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static long[] dp;
    static List<int[]>[] list;
    static int[] visit;
    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        dp = new long[n+2];
        if (n == 1) {
            System.out.println(4);
            return;
        }
        if (n == 2) {
            System.out.println(6);
            return;
        }
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 2; i <= n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n] * 2 + dp[n + 1] * 2);
    }

}