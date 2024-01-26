import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_007;
    static int MOD = 1_000_000_007;
    static int n;
    static int m;
    static int k;

    static int[] arr;
    static int[] arr2;
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
    static int[][] arr1;
    static int count = 0;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

        }
        Arrays.sort(arr);
        int start = 0;
        int end = 1_000_000_001;

        int result = 0;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (check(mid)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);

    }

    private static boolean check(int mid) {
        long count = 1;
        int start = 0;
        for (int i = 1; i < n; i++) {
            long tmp = arr[i] - arr[start];
            if (tmp >= mid) {
                count++;
                start = i;
            }
        }
        return count >= m;
    }


}