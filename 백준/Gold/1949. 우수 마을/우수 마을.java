import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int MOD = 1000000000;
    static int n;
    static int r;
    static int m;

    static int[] arr;
    static List<Integer>[] graph;
    static List<Integer>[] list;
    static int[] visit;
    static int[] in;
    static int[] out;
    static int[] tree;

    static int count = 0;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visit = new int[n + 1];
        graph = new List[n + 1];
        list = new List[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1);
        dp = new long[n + 1][2];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        long a = recur(1, 0);
        long b = recur(1, 1);

        System.out.println(Math.max(a, b));

    }

    private static long recur(int cur, int pre) {
        if (list[cur].size() == 0) {
            if (pre == 1) {
                return arr[cur];
            }
            return 0;
        }
        if (dp[cur][pre] != -1) {
            return dp[cur][pre];
        }
        dp[cur][pre] = 0;
        if (pre == 0) {
            for (int i = 0; i < list[cur].size(); i++) {
                dp[cur][pre] += Math.max(recur(list[cur].get(i), 0), recur(list[cur].get(i), 1));
            }
        } else {
            dp[cur][pre] = arr[cur];
            for (int i = 0; i < list[cur].size(); i++) {
                dp[cur][pre] += recur(list[cur].get(i), 0);
            }
        }
        return dp[cur][pre];
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

}