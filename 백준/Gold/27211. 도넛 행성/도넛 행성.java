import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int MOD = 1000000000;
    static int n;
    static int r;
    static int m;
    static int k;

    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static List<Integer>[] list;

    static int count = 0;
    static int[][] visit;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] == 0 && arr[i][j] == 0) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        visit[x][y] = 1;
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int tx = (tmp[0] + dx[i] + n) % n;
                int ty = (tmp[1] + dy[i] + m) % m;
                if (visit[tx][ty] == 1 || arr[tx][ty] == 1) {
                    continue;
                }
                visit[tx][ty] = 1;
                q.add(new int[]{tx, ty});

            }
        }
    }


}