import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_007;
    static int MOD = 1_000_000_007;
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
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        int[] min = new int[n + 1];
        min[0] = INF;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
            min[i] = Math.min(min[i - 1], arr[i - 1]);
        }
        count = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            count = Math.max(count, arr[i] - min[i]);
        }
        System.out.println(count);

    }

}