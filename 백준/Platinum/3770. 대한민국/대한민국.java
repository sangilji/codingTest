import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

    static int[][] arr;
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
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[k + 1][2];
            tree = new int[(m + 1) << 2];
            for (int j = 1; j <= k; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < 2; l++) {
                    arr[j][l] = Integer.parseInt(st.nextToken());
                }
            }
            Arrays.sort(arr, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            });
            long result = 0;
            for (int j = 1; j <= k; j++) {
                result += get(1, 1, m, arr[j][1] + 1, m);
                update(1, 1, m, arr[j][1], 1);
            }
            sb.append("Test case ").append(i + 1).append(": ").append(result).append("\n");
        }
        System.out.println(sb);

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
        if (start > index || end < index) {
            return;
        }
        if (start == end) {
            tree[node] += value;
            return;
        }
        int mid = (start + end) >> 1;
        update(node << 1, start, mid, index, value);
        update(node << 1 | 1, mid + 1, end, index, value);
        tree[node] = tree[node << 1] + tree[node << 1 | 1];
    }

}