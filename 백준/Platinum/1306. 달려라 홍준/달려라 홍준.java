import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_007;
    static int MOD = 1_000_000_007;
    static int n;
    static int m;

    static long[] arr;
    static long[] tree;
    static List<int[]>[] list;
    static int[] dx = {1, 0, 1, 1};
    static int[] dy = {1, 1, 0, -1};

    static long count = 0;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new long[n + 1];
        tree = new long[(n + 1) << 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        init(1, 1, n);
        for (int i = m; i <= n - m + 1; i++) {
            sb.append(get(1, 1, n, i - m + 1, i + m - 1)).append(" ");
        }
        System.out.println(sb);

    }

    private static long get(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return -123;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) >> 1;
        return Math.max(get(node << 1, start, mid, left, right), get(node << 1 | 1, mid + 1, end, left, right));
    }

    private static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) >> 1;
        init(node << 1, start, mid);
        init(node << 1 | 1, mid + 1, end);
        tree[node] = Math.max(tree[node << 1], tree[node << 1 | 1]);
    }


}