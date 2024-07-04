import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int INF = 1_000_000_000;
    static int n;
    static int m;
    static int k;
    static int str;
    static int[] arr;
    static int[] tree;
    static int[] treeMaxIndex;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][][] dp;
    static List<int[]>[] list;
    static int[] visit;
    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        tree = new int[(n + 1) << 2];
        treeMaxIndex = new int[(n + 1) << 2];
        init(1, 1, n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (command == 1) {
                update(1, 1, n, a, b);
            } else {
               int maxIndex = getIndex(1, 1, n, a, b);
                int one = getMax(1, 1, n, maxIndex, maxIndex);
                int two = Math.max(getMax(1, 1, n, a, maxIndex-1),getMax(1, 1, n, maxIndex+1, b));
                sb.append(one + two).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int getMax(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return -123123;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return Math.max(getMax(node << 1, start, mid, left, right),getMax(node << 1 | 1, mid + 1, end, left, right));
    }

    private static int getIndex(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return 0;
        }
        if (left <= start && end <= right) {
            return treeMaxIndex[node];
        }
        int mid = (start + end) / 2;
        int a = getIndex(node << 1, start, mid, left, right);
        int b = getIndex(node << 1 | 1, mid + 1, end, left, right);
        if (arr[a] >= arr[b]) {
            return a;
        } else {
            return b;
        }
    }

    private static void update(int node, int start, int end, int index, int value) {
        if (index < start || end < index) {
            return;
        }
        if (start == end) {
            arr[start] = value;
            tree[node] = value;
            return;
        }
        int mid = (start + end) / 2;
        update(node << 1, start, mid, index, value);
        update(node << 1 | 1, mid + 1, end, index, value);
        if (tree[node << 1] >= tree[node << 1 | 1]) {
            tree[node] = tree[node << 1];
            treeMaxIndex[node] = treeMaxIndex[node << 1];
        } else {
            tree[node] = tree[node << 1 | 1];
            treeMaxIndex[node] = treeMaxIndex[node << 1 | 1];

        }
    }

    private static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            treeMaxIndex[node] = start;
            return;
        }
        int mid = (start + end) / 2;
        init(node << 1, start, mid);
        init(node << 1 | 1, mid + 1, end);
        if (tree[node << 1] >= tree[node << 1 | 1]) {
            tree[node] = tree[node << 1];
            treeMaxIndex[node] = treeMaxIndex[node << 1];
        } else {
            tree[node] = tree[node << 1 | 1];
            treeMaxIndex[node] = treeMaxIndex[node << 1 | 1];

        }
    }

}