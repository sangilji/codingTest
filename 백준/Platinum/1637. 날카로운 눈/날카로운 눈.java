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
        n = Integer.parseInt(br.readLine());
        arr1 = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long start = 1;
        long end = Integer.MAX_VALUE;
        long result = -1;
        while (start <= end) {
            long mid = (start + end) >> 1;
            if (check(mid) % 2 == 1) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (result == -1) {
            System.out.println("NOTHING");
            return;
        }
        sb.append(result).append(" ").append(check(result) - check(result - 1));
        System.out.println(sb);


    }

    private static long check(long mid) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (mid >= arr1[i][0]) {// a + kb <=c
                count += 1 + ((Math.min(arr1[i][1], mid) - arr1[i][0]) / arr1[i][2]);
            }
        }
        return count;
    }


}