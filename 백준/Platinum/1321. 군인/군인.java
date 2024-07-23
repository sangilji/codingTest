import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

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
    static int[] tree;
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
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        tree = new int[(n + 1) << 2];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        init(1, 1, n);
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                update(1, 1, n, a, b);
            } else {
                int a = Integer.parseInt(st.nextToken());
                sb.append(query(a)).append("\n");
            }
        }
        System.out.println(sb);

    }

    private static int query(int a) {
        int start = 1;
        int end = n;
        int result = n;
        while (start <= end) {

            int mid = (start + end) / 2;
            if (get(1, 1, n, 1, mid) < a) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }
        return result;
    }

    private static int get(int node, int start, int end, int left, int right) {
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
        if (start > index || end < index) {
            return;
        }
        if (start == end) {
            tree[node] += value;
            arr[start] += value;
            return;
        }
        int mid = (start + end) >> 1;
        update(node << 1, start, mid, index, value);
        update(node << 1 | 1, mid + 1, end, index, value);
        tree[node] = tree[node << 1] + tree[node << 1 | 1];
    }

    private static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) >> 1;
        init(node << 1, start, mid);
        init(node << 1 | 1, mid + 1, end);
        tree[node] = tree[node << 1] + tree[node << 1 | 1];
    }


}