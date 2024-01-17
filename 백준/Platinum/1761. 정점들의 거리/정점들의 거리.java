import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_007;
    static int MOD = 1_000_000_007;
    static int n;
    static int m;

    static int[] arr;
    static int[] costs;
    static int[] visit;
    static int[] sz;
    static int[] depth;
    static int[] parent;
    static int[] top;
    static int[] in;
    static int[] out;
    static long[] tree;
    static List<Integer>[] list;
    static List<int[]>[] graph;
    static int[] dx = {1, 0, 1, 1};
    static int[] dy = {1, 1, 0, -1};

    static int count = 0;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new List[n + 1];
        list = new List[n + 1];
        arr = new int[n + 1];
        tree = new long[(n + 1) << 2];
        costs = new int[n + 1];
        visit = new int[n + 1];
        sz = new int[n + 1];
        depth = new int[n + 1];
        parent = new int[n + 1];
        top = new int[n + 1];
        in = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        dfs(1);
        dfs2(1);
        dfs3(1);
        for (int i = 1; i <= n; i++) {
            update(1, 1, n, in[i], costs[i]);
        }
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(query(a, b)).append("\n");

        }
        System.out.println(sb);
    }

    private static long query(int a, int b) {
        long sum = 0;
        while (top[a] != top[b]) {
            if (depth[top[a]] < depth[top[b]]) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            sum += get(1, 1, n, in[top[a]], in[a]);
            a = parent[top[a]];
        }
        if (a == b) {
            return sum;
        }
        if (depth[a] > depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        return sum + get(1, 1, n, in[a] + 1, in[b]);
    }

    private static long get(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) >> 1;
        return get(node << 1, start, mid, left, right) + get(node << 1 | 1, mid + 1, end, left, right);
    }

    private static void update(int node, int start, int end, int index, int value) {
        if (index < start || end < index) {
            return;
        }
        if (start == end) {
            tree[node] = value;
            return;
        }
        int mid = (start + end) >> 1;
        update(node << 1, start, mid, index, value);
        update(node << 1 | 1, mid + 1, end, index, value);
        tree[node] = tree[node << 1 | 1] + tree[node << 1];
    }

    private static void dfs3(int cur) {
        in[cur] = ++count;
        for (int i = 0; i < list[cur].size(); i++) {
            if (i == 0) {
                top[list[cur].get(i)] = top[cur];
            } else {
                top[list[cur].get(i)] = list[cur].get(i);
            }
            dfs3(list[cur].get(i));
        }

    }


    private static void dfs(int cur) {
        visit[cur] = 1;
        for (int i = 0; i < graph[cur].size(); i++) {
            if (visit[graph[cur].get(i)[0]] == 1) {
                costs[cur] = graph[cur].get(i)[1];
                continue;
            }
            list[cur].add(graph[cur].get(i)[0]);
            dfs(graph[cur].get(i)[0]);
        }
    }

    private static void dfs2(int cur) {
        sz[cur] = 1;
        for (int i = 0; i < list[cur].size(); i++) {
            depth[list[cur].get(i)] = depth[cur] + 1;
            parent[list[cur].get(i)] = cur;
            dfs2(list[cur].get(i));
            if (sz[list[cur].get(0)] < sz[list[cur].get(i)]) {
                Collections.swap(list[cur], 0, i);
            }
        }
    }

}