import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int count = 0;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 1, 0};

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1, n - 1, 0);
        System.out.println(count);
    }

    private static void dfs(int x, int y, int n, int shape) {
        if (x == n && y == n) {
            count++;
            return;
        }
        if (shape == 0) {
            for (int i = 0; i < 2; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                if (i == 1) {
                    if (tx > n || ty > n || map[tx][ty] == 1 || map[tx - 1][ty] == 1 || map[tx][ty - 1] == 1) {
                        continue;
                    }
                } else {
                    if (tx > n || ty > n || map[tx][ty] == 1) {
                        continue;
                    }
                }
                dfs(tx, ty, n, i);
            }
        } else if (shape == 1) {
            for (int i = 0; i < 3; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                if (i == 1) {
                    if (tx > n || ty > n || map[tx][ty] == 1 || map[tx - 1][ty] == 1 || map[tx][ty - 1] == 1) {
                        continue;
                    }
                } else {
                    if (tx > n || ty > n || map[tx][ty] == 1) {
                        continue;
                    }
                }
                dfs(tx, ty, n, i);
            }
        } else {
            for (int i = 1; i < 3; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                if (i == 1) {
                    if (tx > n || ty > n || map[tx][ty] == 1 || map[tx - 1][ty] == 1 || map[tx][ty - 1] == 1) {
                        continue;
                    }
                } else {
                    if (tx > n || ty > n || map[tx][ty] == 1) {
                        continue;
                    }
                }
                dfs(tx, ty, n, i);
            }
        }
    }

}
