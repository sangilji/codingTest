import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_007;
    static int n;
    static int m;
    static int k;

    static int[] arr;
    static int[] arr2;
    static int[] costs;
    static int[] visit;
    static int[] visit2;
    static long[] sz;
    static int[] depth;
    static int[] parent;
    static int[] top;
    static int[] in;
    static int[] out;
    static long[] tree_min;
    static long[] tree_max;
    static List<Integer>[] list;
    static List<Integer>[] graph;
    static int[] dx = {1, 0, 1, 1};
    static int[] dy = {1, 1, 0, -1};
    static int[][] arr1;
    static long count = 0;
    static int[][] dp;
    static int[][] dp2;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        list = new List[n + 1];
        graph = new List[n + 1];
        visit = new int[n + 1];
        sz = new long[n + 1];
        for (int i = 0; i <= n; i++) {
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

        arr = new int[n - 1];
        visit = new int[n - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs2(1);
        for (int i = 0; i <= n; i++) {
            sz[i] *= (n - sz[i]);
        }
        Arrays.sort(sz);

        for (int i = 0; i < n - 1; i++) {
            count += sz[n-i] * arr[i];
            count %= MOD;
        }
        System.out.println(count);
    }

    private static void dfs2(int cur) {
        sz[cur] = 1;
        for (int i = 0; i < list[cur].size(); i++) {
            dfs2(list[cur].get(i));
            sz[cur] += sz[list[cur].get(i)];
        }
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