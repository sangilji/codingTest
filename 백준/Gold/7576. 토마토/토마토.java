import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int MOD = 1_000_000_000;
    static int n;
    static int r;
    static int m;
    static int k;

    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Integer>[] list;

    static int count = 0;
    static int[] arr2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());


    }

    private static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                }
            }
        }
        int max = 0;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            max = Math.max(max, tmp[2]);
            for (int i = 0; i < 4; i++) {
                int tx = tmp[0] + dx[i];
                int ty = tmp[1] + dy[i];
                if (tx < 0 || ty < 0 || tx >= n || ty >= m) {
                    continue;
                }
                if (arr[tx][ty] == 0) {
                    q.add(new int[]{tx, ty, tmp[2] + 1});
                    arr[tx][ty] = tmp[2] + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    return -1;
                }
            }
        }
        return max;
    }


}