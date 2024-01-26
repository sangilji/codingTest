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
        st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        for (int i = 0; i < n; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            if (bs(i + 1, x + height, y) && bs(i + 1, x, y + width) && bs(i + 1, x + height, y + width)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean bs(int start, int x, int y) {
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (arr[mid][0] < x) {
                start = mid + 1;
            } else if (arr[mid][0] > x) {
                end = mid - 1;
            } else {
                if (arr[mid][1] < y) {
                    start = mid + 1;
                } else if (arr[mid][1] > y) {
                    end = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }


}