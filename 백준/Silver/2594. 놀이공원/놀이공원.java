import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_007;
    static int MOD = 1_000_000_007;
    static int n;
    static int m;
    static int k;

    static int[][] arr;
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
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        count = toMinute(arr[0][0]) - 10 - 600;
        int endMax = 0;
        for (int i = 1; i < n; i++) {
            endMax = Math.max(endMax, toMinute(arr[i - 1][1]) + 10);
            if (toMinute(arr[i][0]) - 10 > endMax) {
                count = Math.max((toMinute(arr[i][0]) - 10) - endMax, count);
            }
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));
        count = Math.max(toMinute(2200) - (toMinute(arr[n - 1][1]) + 10), count);
        System.out.println(Math.max(count, 0));
    }

    private static int toMinute(int time) {
        String s = String.valueOf(time);
        return Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(2));
    }


}