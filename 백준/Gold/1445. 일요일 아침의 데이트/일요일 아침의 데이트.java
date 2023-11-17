import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int n;
    static int r;
    static int m;
    static int k;
    static int x;
    static char[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Integer>[] list;

    static int count = 0;
    static int[] arr2;
    static int[][] dp;
    static int[] visit = new int[n + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        bfs();

    }

    private static void bfs() {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] == o2[2]) {
                return o1[3] - o2[3];
            }
            return o1[2] - o2[2];
        });
        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'S') {
                    q.add(new int[]{i, j, 0, 0});
                    visit[i][j] = true;
                }
                if (arr[i][j] == 'g') {
                    for (int l = 0; l < 4; l++) {
                        int tx = i + dx[l];
                        int ty = j + dy[l];
                        if (tx < 0 || ty < 0 || tx >= n || ty >= m) {
                            continue;
                        }
                        if (arr[tx][ty] == '.') {
                            arr[tx][ty] = 'n';
                        }
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (arr[tmp[0]][tmp[1]] == 'F') {
                System.out.println(tmp[2] + " " + tmp[3]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + tmp[0];
                int y = dy[i] + tmp[1];
                if (x < 0 || y < 0 || x >= n || y >= m || visit[x][y]) {
                    continue;
                }
                visit[x][y] = true;
                if (arr[x][y] == 'g') {
                    q.add(new int[]{x, y, tmp[2] + 1, tmp[3]});
                } else if (arr[x][y] == 'n') {
                    q.add(new int[]{x, y, tmp[2], tmp[3] + 1});
                } else {
                    q.add(new int[]{x, y, tmp[2], tmp[3]});
                }

            }

        }

    }


}