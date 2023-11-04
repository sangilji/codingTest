import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int MOD = 1000000000;
    static int n;
    static int r;
    static int m;
    static int k;

    static int[][] arr;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static List<Integer>[] list;

    static int count = 0;
    static int[][] visit;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        bfs(x, y);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(arr[a][b]).append(" ");
        }
        System.out.println(sb);

    }

    private static void bfs(int x, int y) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        for (int i = 0; i <= n; i++) {
            Arrays.fill(arr[i], 123123123);
        }
        arr[x][y] = 0;
        q.add(new int[]{x, y, 0});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            for (int i = 0; i < 8; i++) {
                int tx = tmp[0] + dx[i];
                int ty = tmp[1] + dy[i];
                if (tx <= 0 || ty <= 0 || tx > n || ty > n) {
                    continue;
                }
                if (arr[tx][ty] > tmp[2] + 1) {
                    arr[tx][ty] = tmp[2] + 1;
                    q.add(new int[]{tx, ty, tmp[2] + 1});
                }
            }
        }
    }


}