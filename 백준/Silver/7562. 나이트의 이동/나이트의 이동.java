import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int MOD = 1_000_000_000;
    static int n;
    static int r;
    static int m;
    static int k;

    static int[] arr;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static List<Integer>[] list;

    static int count = 0;
    static int[] arr2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int lastX = Integer.parseInt(st.nextToken());
            int lastY = Integer.parseInt(st.nextToken());
            sb.append(bfs(x, y, lastX, lastY)).append("\n");
        }
        System.out.println(sb);


    }

    private static int bfs(int x, int y, int lastX, int lastY) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        q.add(new int[]{x, y, 0});
        boolean[][] visit = new boolean[n][n];
        visit[x][y] = true;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[0] == lastX && tmp[1] == lastY) {
                return tmp[2];
            }
            for (int i = 0; i < 8; i++) {
                int tx = tmp[0] + dx[i];
                int ty = tmp[1] + dy[i];
                if (tx < 0 || ty < 0 || tx >= n || ty >= n || visit[tx][ty]) {
                    continue;
                }
                visit[tx][ty] = true;
                q.add(new int[]{tx, ty, tmp[2] + 1});
            }
        }
        return -1;
    }


}