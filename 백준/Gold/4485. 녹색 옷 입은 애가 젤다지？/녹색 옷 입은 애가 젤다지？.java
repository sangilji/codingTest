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
    static int[] tree;
    static int[] treeMaxIndex;
    static int[] dx = {1, 0, -1, 0};

    static int[] dy = {0, 1, 0, -1};
    static long[] dp;
    static List<int[]>[] list;
    static List<int[]>[] list2;
    static int[] visit;
    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());

        while (true) {
            count++;
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("Problem ").append(count).append(": ");
            sb.append(bfs(0, 0)).append("\n");
        }
        System.out.println(sb);



    }

    private static int bfs(int x, int y) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }
        dist[x][y] = arr[x][y];
        q.add(new int[]{x, y, dist[x][y]});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[2]!=dist[tmp[0]][tmp[1]]) continue;

            for (int i = 0; i < 4; i++) {
                int tx = tmp[0] + dx[i];
                int ty = tmp[1] + dy[i];
                if (tx < 0 || tx >= n || ty < 0 || ty >= n) continue;
                if (dist[tx][ty] > tmp[2] + arr[tx][ty]) {
                    dist[tx][ty] = tmp[2] + arr[tx][ty];
                    q.add(new int[]{tx, ty, dist[tx][ty]});
                }
            }
        }

        return dist[n - 1][n - 1];

    }


}