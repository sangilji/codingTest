import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_007;
    static int n;
    static int r;
    static int m;
    static int c;
    static int x;
    static int[] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<int[]>[] list;

    static long count = 0;
    static int[] arr2;
    static int[][] dp;
    static long[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new int[1002];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            arr[a] = Integer.parseInt(st.nextToken());
        }
        int[] suffix_max = new int[1002];
        int[] prefix_max = new int[1002];
        for (int i = 1; i <= 1000; i++) {
            suffix_max[i] = Math.max(suffix_max[i - 1], arr[i]);
        }
        for (int i = 1000; i >= 1; i--) {
            prefix_max[i] = Math.max(prefix_max[i + 1], arr[i]);
        }
        for (int i = 1; i <= 1000; i++) {
            int min = Math.min(suffix_max[i], prefix_max[i]);

            count += min;
        }
        System.out.println(count);
    }


}