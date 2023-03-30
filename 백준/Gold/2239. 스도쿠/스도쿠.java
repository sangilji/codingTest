import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] sdoku;
    static boolean[][] a = new boolean[10][10];
    static boolean[][] b = new boolean[10][10];
    static boolean[][] c = new boolean[10][10];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sdoku = new int[9][9];

        for (int i = 0; i < 9; i++) {
            sdoku[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < 9; j++) {
                if (sdoku[i][j] != 0) {
                    a[i][sdoku[i][j]] = true;
                    b[j][sdoku[i][j]] = true;
                    c[square(i, j)][sdoku[i][j]] = true;
                }
            }
        }
        dfs(0);
        System.out.println(sb);
    }

    static StringBuilder sb = new StringBuilder();

    private static boolean dfs(int z) {
        cnt += 1;
        if (cnt >= 10000000) {
            return true;
        }
        if (z == 81) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sdoku[i][j]);
                }
                sb.append("\n");
            }
            return true;
        }
        int x = z / 9;
        int y = z % 9;
        if (sdoku[x][y] != 0) {
            return dfs(z + 1);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (!a[x][i] && !b[y][i] && !c[square(x, y)][i]) {
                    a[x][i] = b[y][i] = c[square(x, y)][i] = true;
                    sdoku[x][y] = i;
                    if (dfs(z + 1)) {
                        return true;
                    }
                    sdoku[x][y] = 0;
                    a[x][i] = b[y][i] = c[square(x, y)][i] = false;
                }
            }
        }
        return false;
    }

    private static int square(int x, int y) {
        return (x / 3) * 3 + (y / 3);
    }
}