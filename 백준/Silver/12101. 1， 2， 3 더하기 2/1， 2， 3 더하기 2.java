import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    static int count = 0;
    static int[][][][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        recur(0, "");
        list.sort(String::compareTo);
        if (list.size() < m) {
            System.out.println(-1);
            return;
        }
        System.out.println(String.join("+", list.get(m - 1).split("")));

    }

    private static void recur(int depth, String s) {
        if (depth > n) {
            return;
        }
        if (depth == n) {
            list.add(s);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            recur(depth + i, s + i);
        }
    }


}