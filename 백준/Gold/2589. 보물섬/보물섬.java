import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_009;
    static int n;
    static int m;
    static int k;

    static int[][] arr;
    static int sum;
    static int[][] visit;
    static int[] price;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr1;
    static int count = 0;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<Integer> list;

    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (tmp[j] == 'L') {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    count = Math.max(count, bfs(i, j));
                }
            }
        }
        System.out.println(count);
    }

    private static int bfs(int x, int y) {

        Queue<int[]> q = new ArrayDeque<>();
        visit = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit[i], -1);
        }
        q.add(new int[]{x, y});
        visit[x][y] = 0;
        int result = 0;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int tx = tmp[0] + dx[i];
                int ty = tmp[1] + dy[i];
                if (tx < 0 || ty < 0 || tx >= n || ty >= m || visit[tx][ty] != -1 || arr[tx][ty] == 1) {
                    continue;
                }
                visit[tx][ty] = visit[tmp[0]][tmp[1]] + 1;
                q.add(new int[]{tx, ty});
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result = Math.max(result, visit[i][j]);
            }
        }
        return result;
    }


}