import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_007;
    static int n;
    static int r;
    static int m;
    static int c;
    static int x;
    static int[] arr;
    static long[] tree;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<int[]>[] list;

    static long count = 0;
    static int[] arr2;
    static int[][] dp;
    static long[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        tree = new long[(n + 1) << 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long count = 0;

        for (int i = n; i >= 1; i--) {
            count += get(1, 1, n, 1, arr[i] - 1);
            update(1, 1, n, arr[i]);
        }
        System.out.println(count);
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

    private static void update(int node, int start, int end, int index) {
        if (index < start || index > end) {
            return;
        }
        if (start == end) {
            tree[node] = 1;
            return;
        }
        int mid = (start + end) >> 1;

        update(node << 1, start, mid, index);
        update(node << 1 | 1, mid + 1, end, index);
        tree[node] = tree[node << 1] + tree[node << 1 | 1];

    }
}