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

    static int[] arr;
    static int[] tree;
    static double sum;
    static int[] visit;
    static int[] parent;
    static int[] size;
    static int[] min;
    static int[] max;
    static int[] dx = {1, -1, 1, -1};
    static int[] dy = {1, 1, -1, -1};
    static int[] arr1;
    static int count = 0;
    static long[] dp;
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] list;
    static List<Integer>[] list2;

    static int[] result;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            String t = br.readLine();
            if (t == null) {
                break;
            }
            st = new StringTokenizer(t);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n + 1];
            tree = new int[(n + 1) << 2];
            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] != 0) {
                    arr[i] /= Math.abs(arr[i]);
                }
            }
            init(1, 1, n);

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                String c = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (c.equals("C")) {
                    update(1, 1, n, a, b);
                } else {
                    int tmp = get(1, 1, n, a, b);
                    if (tmp == 0) {
                        sb.append(0);
                    } else if (tmp < 0) {
                        sb.append("-");
                    } else {
                        sb.append("+");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static int get(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return 1;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) >> 1;
        return get(node << 1, start, mid, left, right) * get(node << 1 | 1, mid + 1, end, left, right);
    }

    private static void update(int node, int start, int end, int index, int value) {
        if (start > index || end < index) {
            return;
        }
        if (start == end) {
            arr[index] = value;
            tree[node] = value;
            if (value != 0) {
                tree[node] /= Math.abs(value);
            }
            return;
        }
        int mid = (start + end) >> 1;
        update(node << 1, start, mid, index, value);
        update(node << 1 | 1, mid + 1, end, index, value);
        tree[node] = tree[node << 1] * tree[node << 1 | 1];
    }

    private static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) >> 1;
        init(node << 1, start, mid);
        init(node << 1 | 1, mid + 1, end);
        tree[node] = tree[node << 1] * tree[node << 1 | 1];
    }

}