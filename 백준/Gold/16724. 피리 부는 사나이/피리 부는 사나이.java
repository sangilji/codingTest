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
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String tmp[] = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                if (tmp[j].equals("R")) {
                    map[i][j] = 0;
                } else if (tmp[j].equals("D")) {
                    map[i][j] = 1;
                } else if (tmp[j].equals("L")) {
                    map[i][j] = 2;
                } else {
                    map[i][j] = 3;
                }
            }
        }
        int result = 0;
        int number = 4;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] < 4) {
                    result += bfs(i, j, number++);
                }
            }
        }
        System.out.println(result);
    }

    private static int bfs(int x, int y, int number) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int dis = map[tmp[0]][tmp[1]];
            map[tmp[0]][tmp[1]] = number;
            int tx = tmp[0] + dx[dis];
            int ty = tmp[1] + dy[dis];
            if (tx < 0 || ty < 0 || tx >= n || ty >= m) {
                return 1;
            }
            if (map[tx][ty] == number) {
                return 1;
            }
            if (map[tx][ty] != number && map[tx][ty] > 3) {
                return 0;
            }
            q.add(new int[]{tx, ty});
        }
        return 0;
    }

}