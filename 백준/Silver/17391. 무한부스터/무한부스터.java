import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class Main {
    static int n;
    static int m;
    static boolean[][] visit;
    static int[][] map;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }

    private static void bfs() {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o1[2]==o2[2]){
                return map[o2[0]][o2[1]]- map[o1[0]][o1[1]];
            }
            return o1[2]-o2[2];
        });
        q.add(new int[]{1, 1, 0});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (visit[tmp[0]][tmp[1]]) {
                continue;
            }
            visit[tmp[0]][tmp[1]] = true;

            if (visit[n][m]) {
                System.out.println(tmp[2]);
                return;
            }
            for (int i = map[tmp[0]][tmp[1]]; i >0; i--) {
                for (int j = 0; j < 2; j++) {
                    int tx = tmp[0] + dx[j] * i;
                    int ty = tmp[1] + dy[j] * i;
                    if (tx < 1 || ty < 1 || tx >= n + 1 || ty >= m + 1) {
                        continue;
                    }
                    q.add(new int[]{tx, ty, tmp[2] + 1});
                }
            }
        }
    }
}
