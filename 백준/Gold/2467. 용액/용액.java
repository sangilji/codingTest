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

    static int[] arr;
    static int[] costs;
    static int[] visit;
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

    static int count = 0;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start;
        int end;
        int abs = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            start = i + 1;
            end = n - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (Math.abs(tmp + arr[mid]) < abs) {
                    a = tmp;
                    b = arr[mid];
                    abs = Math.abs(a + b);
                }

                if (tmp + arr[mid] <= 0) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        System.out.println(Math.min(a, b) + " " + Math.max(a, b));
    }


}