import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("Problem ").append(t).append(": ");
            t++;
            sb.append(bfs(map)).append("\n");
        }
        System.out.println(sb);

    }

    private static int bfs(int[][] map) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        q.add(new int[]{0,0,map[0][0]});
        boolean[][] visit = new boolean[n][n];
        visit[0][0] = true;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            if (tmp[0] == n - 1 && tmp[1] == n - 1) {
                return tmp[2];
            }
            for (int i = 0; i < 4; i++) {
                int x = tmp[0] + dx[i];
                int y = tmp[1] + dy[i];
                if (x<0||y<0|| x>=n || y>=n || visit[x][y]){
                    continue;
                }
                visit[x][y] = true;
                q.add(new int[]{x,y,tmp[2]+map[x][y]});
            }
        }

        return 0;
    }
}