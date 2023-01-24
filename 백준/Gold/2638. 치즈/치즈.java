import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visit;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        while (true) {
            visit = new boolean[n][m];
            check(map);
            boolean b = false;
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (map[i][j] == 1) {
                        int count = 0;
                        b = true;
                        for (int k = 0; k < 4; k++) {
                            int x = dx[k] + i;
                            int y = dy[k] + j;
                            if (map[x][y] == 0 && visit[x][y]) {
                                count++;
                            }
                        }
                        if (count >= 2) {
                            map[i][j] = 0;
                        }
                    }
                }
            }

            if (!b) {
                break;
            }
            result++;
        }
        System.out.println(result);
    }

    private static void check(int[][] map) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = tmp[0] + dx[i];
                int y = tmp[1] + dy[i];
                if (x < 0 || y < 0 || x >= n || y >= m || visit[x][y] || map[x][y] == 1) {
                    continue;
                }
                visit[x][y] = true;
                q.add(new int[]{x, y});
            }
        }

    }
}

