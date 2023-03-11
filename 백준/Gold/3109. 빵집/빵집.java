import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;
    static boolean[][] map;
    static int[] dx = {-1, 0, 1};
    static boolean[] visit;
    static int count = 0;
    static int currentX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        visit = new boolean[r];
        map = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                if (tmp[j].equals("x")) {
                    map[i][j] = true;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            currentX = i;
            dfs(i, 0);

        }

        System.out.println(count);
    }

    private static void dfs(int x, int y) {
        if (y == c - 1) {
            visit[currentX] = true;
            count++;
        }

        for (int i = 0; i < 3; i++) {
            if (visit[currentX]) {
                return;
            }
            int tx = dx[i] + x;
            int ty = y + 1;
            if (tx < 0 || tx >= r || ty >= c || map[tx][ty]) {
                continue;
            }
            map[tx][ty] = true;
            dfs(tx, ty);
        }
        

    }
}