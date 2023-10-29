import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int MOD = 1000000000;
    static int n;
    static int r;
    static int m;
    static int k;

    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};


    static int count = 0;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = x1; j < x2; j++) {
                for (int l = y1; l < y2; l++) {
                    arr[j][l]++;
                }
            }
        }
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    count++;
                    list.add(bfs(i, j));
                }
            }
        }
        sb.append(count).append("\n");
        list.sort(Integer::compareTo);
        for (int i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        arr[x][y]++;
        q.add(new int[]{x, y});
        int count = 1;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int tx = tmp[0] + dx[i];
                int ty = tmp[1] + dy[i];
                if (tx < 0 || ty < 0 || tx >= m || ty >= n || arr[tx][ty] > 0) {
                    continue;
                }
                arr[tx][ty]++;
                count++;
                q.add(new int[]{tx, ty});
            }
        }

        return count;
    }


}