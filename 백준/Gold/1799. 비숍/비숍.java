import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    private static final int[] dx = {-1, -1};
    private static final int[] dy = {-1, 1};
    private static int[][] map;
    static int n;
    static int bMax = 0;
    static int wMax = 0;

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, 0);
        dfs(0, 0, 1);
        System.out.println(bMax + wMax);
    }

    private static void dfs(int count, int y, int bw) {

        for (int i = y; i < n; i++) {
            int start;
            if (bw == 0) {
                start = i % 2;
            } else {
                start = (i + 1) % 2;
            }
            for (int j = start; j < n; j += 2) {
                if (map[i][j] == 1 && check(i, j)) {
                    map[i][j] = 2;
                    dfs(count + 1, i, bw);
                    map[i][j] = 1;
                }
            }

        }
        if (bw == 0) {
            bMax = Math.max(bMax, count);
        } else {
            wMax = Math.max(wMax, count);
        }
    }

    private static boolean check(int x, int y) {
        int tx = x;
        int ty = y;
        while (true) {
            tx += dx[0];
            ty += dy[0];
            if (tx < 0 || ty < 0) {
                break;
            }
            if (map[tx][ty] == 2) {
                return false;
            }
        }
        tx = x;
        ty = y;
        while (true) {
            tx += dx[1];
            ty += dy[1];
            if (tx < 0 || ty >= n) {
                break;
            }
            if (map[tx][ty] == 2) {
                return false;
            }
        }
        return true;
    }


}
