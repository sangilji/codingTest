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

        recur(0);
        System.out.println(sb);
    }

    private static void recur(int depth) {
        if (count == 0) {
            return;
        }
        if (depth == n) {
            if (count == -1) {
                for (int i = 0; i < n; i++) {
                    sb.append(arr[i]);
                }
            }
            count = 0;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            arr[depth] = i;
            if (check(depth)) {
                continue;
            }
            recur(depth + 1);
        }
    }

    private static boolean check(int cur) {
        int count = 1;
        for (int i = cur; i >= (cur / 2) + 1; i--) {
            boolean b = true;
            for (int j = 0; j < count; j++) {
                if (arr[cur - j] != arr[cur - count - j]) {
                    b = false;
                    break;
                }
            }
            count++;
            if (b) {
                return true;
            }
        }
        return false;
    }


}