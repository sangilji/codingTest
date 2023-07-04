import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] originalMap;
    static boolean[][] visit;
    static int maxValue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        originalMap = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());
                maxValue = Math.max(maxValue, originalMap[i][j]);
            }
        }
        int result = 0;
        for (int i = 0; i < maxValue; i++) {
            visit = new boolean[n][n];
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (originalMap[j][k] > i && !visit[j][k]) {
                        bfs(j, k, i);
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
        }
        System.out.println(result);

    }

    private static void bfs(int x, int y, int depth) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int tx = tmp[0] + dx[i];
                int ty = tmp[1] + dy[i];
                if (tx < 0 || ty < 0 || tx >= n || ty >= n || visit[tx][ty] || originalMap[tx][ty] <= depth) {
                    continue;
                }
                visit[tx][ty] = true;
                q.add(new int[]{tx, ty});
            }
        }
    }

}