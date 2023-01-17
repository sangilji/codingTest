import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static boolean[][] visit;
    static int map[][];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        visit = new boolean[n][m];
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String road = s.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = road.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        visit[0][0] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[0] == map.length - 1 && tmp[1] == map[0].length - 1) {
                return tmp[2];
            }
            for (int i = 0; i < 4; i++) {
                int x = tmp[0] + dx[i];
                int y = tmp[1] + dy[i];
                if (x < 0 || y < 0 || x >= map.length || y >= map[0].length || map[x][y] == 0 || visit[x][y]) {
                    continue;
                }
                visit[x][y] = true;
                q.add(new int[]{x, y, tmp[2] + 1});
            }
        }
        return -1;
    }
}
