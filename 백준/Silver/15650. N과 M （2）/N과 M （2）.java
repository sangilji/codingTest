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
    static List<Integer>[] list;
    static List<int[]>[] graph;
    static int[] dx = {1, 0, 1, 1};
    static int[] dy = {1, 1, 0, -1};
    static int[][] arr1;
    static int count = 0;
    static int[][][][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new int[m];
        visit2 = new int[n + 1];
        recur(0, 1);
        System.out.println(sb);


    }

    private static void recur(int depth, int cur) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(visit[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = cur; i <= n; i++) {
            if (visit2[i] == 1) {
                continue;
            }
            visit2[i] = 1;
            visit[depth] = i;
            recur(depth + 1, i + 1);
            visit2[i] = 0;
        }
    }


}