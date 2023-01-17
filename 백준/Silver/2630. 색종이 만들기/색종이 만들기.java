import java.util.Scanner;

public class Main {
    static int[][] map;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = s.nextInt();
            }
        }
        dfs(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void dfs(int x, int y, int size) {
        if (check(x, y, size)) {
            if (map[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }
        dfs(x, y, size / 2);
        dfs(x, y + size / 2, size / 2);

        dfs(x + size / 2, y, size / 2);
        dfs(x + size / 2, y + size / 2, size / 2);
    }

    private static boolean check(int x, int y, int size) {
        int tmp = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != tmp) {
                    return false;
                }
            }
        }
        return true;
    }
}
