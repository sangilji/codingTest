import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] map;
    static int n;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        visit = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        System.out.print(count +" ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'R') {
                    map[i][j] = 'G';

                }
            }
        }
        visit = new boolean[n][n];
        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{x, y});
        visit[x][y] = true;
        char color = map[x][y];
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int tmpX = dx[i] + tmp[0];
                int tmpY = dy[i] + tmp[1];
                if (tmpX < 0 || tmpX >= n || tmpY < 0 || tmpY >= n
                        || map[tmpX][tmpY] != color || visit[tmpX][tmpY]) {
                    continue;
                }
                visit[tmpX][tmpY] = true;
                q.add(new int[]{tmpX, tmpY});
            }
        }

    }
}