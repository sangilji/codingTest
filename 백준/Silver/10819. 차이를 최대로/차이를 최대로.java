import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    static int[] sz;
    static int[] depth;
    static int[] parent;
    static int[] top;
    static int[] in;
    static int[] out;
    static long[] tree_min;
    static long[] tree_max;
    static List<String> list;
    static List<int[]>[] graph;
    static int[] dx = {1, 0, 1, 1};
    static int[] dy = {1, 1, 0, -1};
    static int[][] arr1;
    static int count = -1;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr2 = new int[n];
        visit = new int[n];
        recur(0);
        System.out.println(count);
    }

    private static void recur(int depth) {
        if (depth == n) {
            int tmp = 0;
            for (int i = 0; i < n - 1; i++) {
                tmp += Math.abs(arr2[i] - arr2[i + 1]);
            }
            count = Math.max(tmp, count);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visit[i] == 1) {
                continue;
            }
            visit[i] = 1;
            arr2[depth] = arr[i];
            recur(depth + 1);
            visit[i] = 0;
        }

    }


}