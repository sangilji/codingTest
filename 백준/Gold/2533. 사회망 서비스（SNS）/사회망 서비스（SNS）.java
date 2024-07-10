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
    static int[] dx = {1, 0, -1, 0};

    static int[] dy = {0, 1, 0, -1};
    static int[][] dp;
    static List<Integer>[] list;
    static List<int[]>[] list2;
    static int[] visit;
    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        list = new List[n + 1];
        dp = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        recur(1, -1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void recur(int cur, int parent) {
        dp[cur][1] = 1;
        for (int i = 0; i < list[cur].size(); i++) {
            if (list[cur].get(i) == parent) {
                continue;
            }
            recur(list[cur].get(i), cur);
            dp[cur][1] += Math.min(dp[list[cur].get(i)][0], dp[list[cur].get(i)][1]);
            dp[cur][0] += dp[list[cur].get(i)][1];
        }
    }

}