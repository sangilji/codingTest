import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int n;
    static char[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        bfs();
    }

    private static void bfs() {
        int[] start = findCenter();
        int[] result = findResult();
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[3]));
        q.add(new int[]{start[0], start[1], start[2], 0});
        boolean[][][] visit = new boolean[n][n][2];
        visit[start[0]][start[1]][start[2]] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
//            System.out.println(Arrays.toString(tmp));
            if (tmp[0] == result[0] && tmp[1] == result[1] && tmp[2] == result[2]) {
                System.out.println(tmp[3]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + tmp[0];
                int y = dy[i] + tmp[1];
                if (tmp[2] == 0) {
                    if (x < 0 || x >= n || y - 1 < 0 || y + 1 >= n || visit[x][y][tmp[2]] || map[x][y] == '1' || map[x][y - 1] == '1' || map[x][y + 1] == '1') {
                        continue;
                    }
                } else {
                    if (x - 1 < 0 || x + 1 >= n || y < 0 || y >= n || visit[x][y][tmp[2]] || map[x][y] == '1' || map[x - 1][y] == '1' || map[x + 1][y] == '1') {
                        continue;
                    }
                }
                visit[x][y][tmp[2]] = true;
                q.add(new int[]{x, y, tmp[2], tmp[3] + 1});
            }
            if (tmp[2] == 0) {
                if (tmp[0] == 0 || tmp[0] == n - 1 || visit[tmp[0]][tmp[1]][1] ||
                        map[tmp[0] - 1][tmp[1]] == '1' || map[tmp[0] - 1][tmp[1] - 1] == '1' || map[tmp[0] - 1][tmp[1] + 1] == '1' ||
                        map[tmp[0] + 1][tmp[1]] == '1' || map[tmp[0] + 1][tmp[1] - 1] == '1' || map[tmp[0] + 1][tmp[1] + 1] == '1') {
                    continue;
                }
            } else {
                if (tmp[1] == 0 || tmp[1] == n - 1 || visit[tmp[0]][tmp[1]][0] ||
                        map[tmp[0]][tmp[1] - 1] == '1' || map[tmp[0] - 1][tmp[1] - 1] == '1' || map[tmp[0] + 1][tmp[1] - 1] == '1' ||
                        map[tmp[0]][tmp[1] + 1] == '1' || map[tmp[0] - 1][tmp[1] + 1] == '1' || map[tmp[0] + 1][tmp[1] + 1] == '1'){
                    continue;
                }
            }
            visit[tmp[0]][tmp[1]][(tmp[2]+1)%2]=true;
            q.add(new int[]{tmp[0], tmp[1], (tmp[2] + 1) % 2, tmp[3] + 1});
        }
        System.out.println(0);
    }

    private static int[] findCenter() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 'B') {
                    if (j + 1 < map.length && map[i][j + 1] == 'B') {
                        return new int[]{i, j + 1, 0};
                    }
                    if (i + 1 < map.length && map[i + 1][j] == 'B') {
                        return new int[]{i + 1, j, 1};
                    }
                }
            }
        }
        return null;
    }

    private static int[] findResult() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 'E') {
                    if (j + 1 < map.length && map[i][j + 1] == 'E') {
                        return new int[]{i, j + 1, 0};
                    }
                    if (i + 1 < map.length && map[i + 1][j] == 'E') {
                        return new int[]{i + 1, j, 1};
                    }
                }
            }
        }
        return null;
    }
}