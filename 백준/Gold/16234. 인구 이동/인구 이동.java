import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int n;
    static int l;
    static int r;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        while (true) {
            visit = new boolean[n][n];
            boolean b = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j]) {
                        if (bfs(i, j)) {
                            b = true;
                        }
                    }
                }
            }
            if (!b) {
                break;
            }
            count++;
        }
        System.out.println(count);
    }

    private static boolean bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> modifyQueue = new ArrayDeque<>();
        q.add(new int[]{x, y});
        modifyQueue.add(q.peek());

        visit[x][y] = true;
        int sum = map[x][y];
        int count = 1;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int tx = tmp[0] + dx[i];
                int ty = tmp[1] + dy[i];
                if (tx < 0 || ty < 0 || tx >= n || ty >= n || visit[tx][ty] || Math.abs(map[tmp[0]][tmp[1]] - map[tx][ty]) < l || Math.abs(map[tmp[0]][tmp[1]] - map[tx][ty]) > r) {
                    continue;
                }
                visit[tx][ty] = true;
                int[] tmp2 = new int[]{tx, ty};
                q.add(tmp2);
                modifyQueue.add(tmp2);
                sum += map[tx][ty];
                count++;
            }
        }

        if (modifyQueue.size() != 1) {
            sum /= count;
            while (!modifyQueue.isEmpty()) {
                int[] tmp = modifyQueue.poll();
                map[tmp[0]][tmp[1]] = sum;
            }
            return true;
        }
        return false;
    }


}