import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] arr;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] arr2;
    static int[][] arr1;

    static long[] tree;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(bfs(x1, y1, x2, y2)).append("\n");

        }
        System.out.println(sb);
    }

    private static int bfs(int x1, int y1, int x2, int y2) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] visit = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit[i], -1);
        }
        q.add(new int[]{x1, y1});
        visit[x1][y1] = 0;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[0] == x2 && tmp[1] == y2) {
                return visit[x2][y2];
            }
            for (int i = 0; i < 8; i++) {
                int tx = dx[i] + tmp[0];
                int ty = dy[i] + tmp[1];
                if (tx < 0 || ty < 0 || tx >= n || ty >= n || visit[tx][ty] != -1) {
                    continue;
                }
                visit[tx][ty] = visit[tmp[0]][tmp[1]] + 1;
                q.add(new int[]{tx, ty});
            }

        }
        return -1;
    }


}