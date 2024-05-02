import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_009;
    static int n;
    static int m;
    static int k;

    static int[][] arr;
    static int[] tree;
    static double sum;
    static int[] visit;
    static int[] parent;
    static int[] size;
    static int[] min;
    static int[] max;
    static int[] dx = {1, -1, 1, -1};
    static int[] dy = {1, 1, -1, -1};
    static int[] arr1;
    static int count = 0;
    static long[] dp;
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] list;
    static List<Integer>[] list2;

    static int[] result;
    static Set<Integer> set = new HashSet<>();
    static int l;
    static int r;
    static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[n][i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(recur(0, 0, 0, 0, 0));


    }

    private static int recur(int depth, int r, int g, int b, int count) {
        if (count > 7) {
            return INF;
        }
        if (depth == n) {
            if (count <= 1) {
                return INF;
            }
            r /= count;
            g /= count;
            b /= count;
            return Math.abs(r - arr[n][0]) + Math.abs(g - arr[n][1]) + Math.abs(b - arr[n][2]);
        }

        int tmp = INF;
        tmp = Math.min(tmp, recur(depth + 1, r + arr[depth][0], g + arr[depth][1], b + arr[depth][2], count + 1));
        tmp = Math.min(tmp, recur(depth + 1, r, g, b, count));

        return tmp;
    }


}