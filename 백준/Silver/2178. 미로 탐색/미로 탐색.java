import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int INF = 1_000_000_000;
    static int n;
    static int m;
    static int k;
    static int str;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][][] dp;
    static List<Integer>[] list;
    static int[] visit;
    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        bfs();


    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] visit = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit[i], -1);
        }
        visit[0][0] = 0;
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            if (tmp[0] == n - 1 && tmp[1] == m - 1) {
                System.out.println(visit[n - 1][m - 1]+1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int tx = dx[i] + tmp[0];
                int ty = dy[i] + tmp[1];
                if (tx < 0 || ty < 0 || tx >= n || ty >= m || visit[tx][ty] != -1 || arr[tx][ty]==0) {
                    continue;
                }
                visit[tx][ty] = visit[tmp[0]][tmp[1]] + 1;
                q.add(new int[]{tx, ty});
            }

        }
    }


}