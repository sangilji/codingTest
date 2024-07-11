import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int INF = 1_000_000_007;
    static int MOD = 1_000_000_007;
    static int n;
    static int m;
    static int k;
    static int str;
    static int[] arr;
    static int[] tree;
    static int[] treeMaxIndex;
    static int[] dx = {1, 0, -1, 0};

    static int[] dy = {0, 1, 0, -1};
    static int[][][] dp;
    static List<Integer>[] list;
    static List<Integer>[] graph;
    static int[] visit;
    static int[] sz;
    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        list = new List[n + 1];
        graph = new List[n + 1];
        visit = new int[n + 1];
        dp = new int[n + 1][10][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
            graph[i] = new ArrayList<>();

        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1);
        System.out.println((recur(1, 0, 0) + recur(1, arr[1], 1)) % MOD);

    }


    private static void dfs(int cur) {
        visit[cur] = 1;
        for (int i = 0; i < graph[cur].size(); i++) {
            if (visit[graph[cur].get(i)] == 1) {
                continue;
            }
            list[cur].add(graph[cur].get(i));
            dfs(graph[cur].get(i));
        }
    }

    private static int recur(int cur, int prev, int flag) {

        if (dp[cur][prev][flag] != -1) {
            return dp[cur][prev][flag];
        }
        int tmp = flag;
        for (int i = 0; i < list[cur].size(); i++) {
            if (arr[list[cur].get(i)] >= prev) {
                tmp += recur(list[cur].get(i), arr[list[cur].get(i)], 1);
                tmp %= MOD;
            }
            tmp += recur(list[cur].get(i), prev, 0);
            tmp %= MOD;
        }

        return dp[cur][prev][flag] = tmp;
    }

}