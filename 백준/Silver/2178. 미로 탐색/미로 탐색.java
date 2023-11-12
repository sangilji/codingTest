import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int n;
    static int r;
    static int m;
    static int k;
    static int x;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<int[]>[] list;

    static int count = 0;
    static int[] arr2;
    static int[][] dp;
    static int[] visit = new int[n + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(tmp[j - 1]);
            }
        }
        bfs();


    }

    private static void bfs() {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        int[][] dist = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);

        }
        dist[1][1] = 1;
        q.add(new int[]{1, 1, 1});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            if (tmp[0] == n && tmp[1] == m) {
                System.out.println(tmp[2]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int tx = dx[i] + tmp[0];
                int ty = dy[i] + tmp[1];
                if (tx <= 0 || ty <= 0 || tx > n || ty > m || arr[tx][ty] == 0) {
                    continue;
                }
                if (dist[tx][ty] > tmp[2] + 1) {
                    dist[tx][ty] = tmp[2] + 1;
                    q.add(new int[]{tx, ty, tmp[2] + 1});
                }
            }
        }

    }


}