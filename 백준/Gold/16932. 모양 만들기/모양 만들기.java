import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[] numbers = new int[5000000];
    static boolean[] visit = new boolean[500000];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        int number = 2;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j, number++);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    result = Math.max(result, find(i, j));
                }
            }
        }
        System.out.println(result);
    }

    private static int find(int x, int y) {
        int sum = 1;

        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (tx < 0 || ty < 0 || tx >= n || ty >= m || map[tx][ty] == 0) {
                continue;
            }
            if (!visit[map[tx][ty]]) {
                visit[map[tx][ty]] = true;
                sum += numbers[map[tx][ty]];
            }

        }
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (tx < 0 || ty < 0 || tx >= n || ty >= m || map[tx][ty] == 0) {
                continue;
            }
            visit[map[tx][ty]] = false;

        }

        return sum;
    }

    private static void bfs(int x, int y, int number) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        int count = 0;
        map[x][y] = number;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                int tx = tmp[0] + dx[i];
                int ty = tmp[1] + dy[i];
                if (tx < 0 || ty < 0 || tx >= n || ty >= m || map[tx][ty] != 1) {
                    continue;
                }
                map[tx][ty] = number;
                q.add(new int[]{tx, ty});
            }
        }
        numbers[number] = count;
    }


}