import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());

    }

    private static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        int result = 0;
        while (true) {
            boolean[][] visit = new boolean[n][m];
            addYear();
            findOne(q);
            if (q.isEmpty()) {
                break;
            }
            result++;
            while (!q.isEmpty()) {
                int[] tmp = q.poll();

                for (int i = 0; i < 4; i++) {
                    int x = tmp[0] + dx[i];
                    int y = tmp[1] + dy[i];
                    if (x < 0 || y < 0 || x >= n || y >= m || map[x][y] == 0 || visit[x][y]) {
                        continue;
                    }
                    visit[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
            if (!check(visit)) {
                return result;
            }
        }
        return 0;
    }

    private static boolean check(boolean[][] visit) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0 && !visit[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void addYear() {
        int[][] minusMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x < 0 || y < 0 || x >= n || y >= m || map[x][y] > 0) {
                        continue;
                    }
                    count++;
                }
                minusMap[i][j] = count;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] -= minusMap[i][j];
                if (map[i][j]<0)
                    map[i][j] = 0;
            }

        }

    }

    private static void findOne(Queue<int[]> q) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    q.add(new int[]{i, j});
                    return;
                }
            }
        }
    }


}