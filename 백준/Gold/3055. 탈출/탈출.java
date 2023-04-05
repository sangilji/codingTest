import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'S') {
                    bfs(i, j);
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> water = new ArrayDeque<>();
        Queue<int[]> current = new ArrayDeque<>();
        int[][] visit = new int[r][c];
        current.add(new int[]{x, y});
        visit[x][y] = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '*') {
                    water.add(new int[]{i, j});
                    visit[i][j] = 2;
                }
            }
        }
        int count = -1;
        while (!current.isEmpty()) {
            count++;
            int t = current.size();
            for (int j = 0; j < t; j++) {
                int[] tmp = current.poll();
                if (map[tmp[0]][tmp[1]] == 'D') {
                    System.out.println(count);
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    int tx = tmp[0] + dx[i];
                    int ty = tmp[1] + dy[i];
                    if (tx < 0 || ty < 0 || tx >= r || ty >= c || visit[tx][ty] > 0 || map[tx][ty] == 'X' || waterCheck(visit, tx, ty)) {
                        continue;
                    }
                    visit[tx][ty] = 1;
                    current.add(new int[]{tx, ty});
                }
            }
            t = water.size();
            for (int j = 0; j < t; j++) {
                int[] tmp = water.poll();
                for (int i = 0; i < 4; i++) {
                    int tx = tmp[0] + dx[i];
                    int ty = tmp[1] + dy[i];
                    if (tx < 0 || ty < 0 || tx >= r || ty >= c || visit[tx][ty] == 2 || map[tx][ty] == 'X' || map[tx][ty]=='D') {
                        continue;
                    }
                    visit[tx][ty] = 2;
                    water.add(new int[]{tx, ty});
                }
            }
        }
        System.out.println("KAKTUS");

    }

    private static boolean waterCheck(int[][] visit, int x, int y) {
        if (map[x][y] == 'D') {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (tx < 0 || ty < 0 || tx >= r || ty >= c) {
                continue;
            }

            if (visit[tx][ty] == 2) {
                return true;
            }
        }
        return false;
    }
}