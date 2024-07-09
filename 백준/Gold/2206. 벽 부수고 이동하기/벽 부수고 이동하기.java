import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int INF = 1_000_000_000;
    static int n;
    static int m;
    static int k;
    static int str;
    static int[][] arr;
    static int[] tree;
    static int[] treeMaxIndex;
    static int[] dx = {1, 0, -1, 0};

    static int[] dy = {0, 1, 0, -1};
    static long[] dp;
    static List<int[]>[] list;
    static List<int[]>[] list2;
    static int[] visit;
    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = tmp[j - 1] - '0';
            }
        }

        int[][] start = bfs(1, 1);
        int[][] end = bfs(n, m);
        int min = start[n][m];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == 1) {
                    min = Math.min(min, start[i][j] + end[i][j]);
                }
            }
        }
        if (min == INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(min + 1);

    }

    private static int[][] bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
        }
        q.add(new int[]{x, y, 0});
        dist[x][y] = 0;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int tx = dx[i] + tmp[0];
                int ty = dy[i] + tmp[1];
                if (tx <= 0 || ty <= 0 || tx > n || ty > m || dist[tx][ty] != INF) {
                    continue;
                }
                dist[tx][ty] = dist[tmp[0]][tmp[1]] + 1;
                if (arr[tx][ty] == 0) {
                    q.add(new int[]{tx, ty, dist[tx][ty]});
                }
            }

        }
        return dist;
    }


}