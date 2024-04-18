import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_009;
    static int n;
    static int m;
    static int k;

    static long[] arr;
    static long[] tree;
    static double sum;
    static int[] visit;
    static int[] parent;
    static int[] size;
    static int[] min;
    static int[] max;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] arr1;
    static int count = 0;
    static long[] dp;
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] list;
    static List<Integer>[] list2;

    static int[] result;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new long[n + 1];
        tree = new long[(n + 1) << 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i], get(1, 1, n, Math.max(0, i - m), i - 1) + dp[i]);
            update(1, 1, n, i, dp[i]);
        }
        long result = Long.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);

    }

    private static void update(int node, int start, int end, int index, long value) {
        if (start > index || end < index) {
            return;
        }
        if (start == end) {
            tree[node] = value;
            return;
        }
        int mid = (start + end) >> 1;
        update(node << 1, start, mid, index, value);
        update(node << 1 | 1, mid + 1, end, index, value);
        tree[node] = Math.max(tree[node << 1], tree[node << 1 | 1]);
    }

    private static long get(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return -1231231312;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) >> 1;
        return Math.max(get(node << 1, start, mid, left, right), get(node << 1 | 1, mid + 1, end, left, right));
    }


}