import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][][] mapDis = new int[n + 1][n + 1][3];
        mapDis[1][2][0] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 0; k < 3; k++) {
                    int x = dx[k] + j;
                    int y = dy[k] + i;

                    if (y > n || x > n || map[x][y] == 1) {
                        continue;
                    }
                    if (k == 0) {
                        mapDis[x][y][0] = mapDis[j][i][0] + mapDis[j][i][1];
                    } else if (k == 1) {
                        if (map[x - 1][y] == 0 && map[x][y - 1] == 0) {
                            mapDis[x][y][1] = mapDis[j][i][1] + mapDis[j][i][0] + mapDis[j][i][2];
                        }
                    } else {
                        mapDis[x][y][2] = mapDis[j][i][1] + mapDis[j][i][2];
                    }
                }
            }
        }


        System.out.print(mapDis[n][n][0] + mapDis[n][n][1] + mapDis[n][n][2]);
           
    }
}