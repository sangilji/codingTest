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
    static int[][] map;
    static int[][] wall = new int[3][2];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max = 0;
    public static void main(String[] args) throws IOException {
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
        dfs(0,0);
        System.out.println(max);
    }

    private static void dfs(int depth,int current) {
        if (depth == 3) {
            check();
            return;
        }
        while (n*m>current) {
            int x = current / m;
            int y = current % m;
            if (map[x][y] == 0) {
                wall[depth][0] = x;
                wall[depth][1] = y;
                dfs(depth + 1, current + 1);
            }
            current++;
        }

    }

    private static void check() {
        int[][] tmpMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            tmpMap[i] = map[i].clone();
        }
        for (int i = 0; i < 3; i++) {
            tmpMap[wall[i][0]][wall[i][1]] = 1;
        }


        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmpMap[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + tmp[0];
                int y = dy[i] + tmp[1];
                if (x < 0 || y < 0 || x >= n || y >= m || tmpMap[x][y] != 0) {
                    continue;
                }
                tmpMap[x][y]=2;
                q.add(new int[]{x, y});
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmpMap[i][j] == 0) {
                    count++;
                }
            }
        }

        max = Math.max(count, max);
    }
}