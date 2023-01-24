import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] cleaner;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int r;
    static int c;

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cleaner = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (cleaner[0] == 0 && map[i][j] == -1) {
                    cleaner[0] = i;
                    cleaner[1] = i + 1;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            spread();
            clean();

        }
        map[cleaner[0]][0] = 0;
        map[cleaner[1]][0] = 0;
        System.out.println(sum());

    }

    private static int sum() {
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }

    private static void clean() {
        for (int i = cleaner[0] - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        for (int i = 0; i < c - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        for (int i = 0; i < cleaner[0]; i++) {
            map[i][c - 1] = map[i + 1][c - 1];
        }
        for (int i = c - 1; i > 0; i--) {
            map[cleaner[0]][i] = map[cleaner[0]][i - 1];
        }
        map[cleaner[0]][1] = 0;

        for (int i = cleaner[1] + 1; i < r - 1; i++) {
            map[i][0] = map[i + 1][0];
        }
        for (int i = 0; i < c - 1; i++) {
            map[r - 1][i] = map[r - 1][i + 1];
        }
        for (int i = r - 1; i > cleaner[1]; i--) {
            map[i][c - 1] = map[i - 1][c - 1];
        }
        for (int i = c - 1; i > 1; i--) {
            map[cleaner[1]][i] = map[cleaner[1]][i - 1];
        }
        map[cleaner[1]][1] = 0;

    }

    private static void spread() {
        int[][] tmp = new int[map.length][map[0].length];
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                int count = 0;
                if (map[i][j] > 0) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x < 0 || y < 0 || x >= r || y >= c || map[x][y] == -1) {
                            continue;
                        }
                        count++;
                        tmp[x][y] += map[i][j] / 5;
                    }
                }
                tmp[i][j] -= (map[i][j] / 5) * count;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] += tmp[i][j];
            }
        }
    }
}
