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
    static String map[][];
    static int w;
    static int b;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new String[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) {
                    bfs(i, j,map[i][j]);
                }
            }
        }
        System.out.println(w+" "+ b);
    }

    private static void bfs(int x, int y,String team) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visit[x][y] = true;
        int count = 1;

        while (!q.isEmpty()){
            int[] tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int tx = tmp[0] + dx[i];
                int ty = tmp[1] + dy[i];
                if (tx<0 || ty<0 || tx>=n || ty>=m || visit[tx][ty] || !map[tx][ty].equals(team)){
                    continue;
                }
                count++;
                visit[tx][ty] = true;
                q.add(new int[]{tx,ty});
            }
        }
        if (team.equals("W")){
            w += count*count;
        } else {
            b += count*count;
        }
    }

}
