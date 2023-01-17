import java.util.Scanner;

public class Main {
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String num = s.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = num.charAt(j) - '0';
            }
        }
        dfs(0, 0, n);
        System.out.println(sb);
    }

    private static void dfs(int x, int y, int size) {
        if (check(x, y, size)) {
            if (map[x][y] == 1) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            return;
        }
        sb.append("(");
        dfs(x, y, size / 2);
        dfs(x, y + size / 2, size / 2);

        dfs(x + size / 2, y, size / 2);
        dfs(x + size / 2, y + size / 2, size / 2);
        sb.append(")");

    }

    private static boolean check(int x, int y, int size) {
        int tmp = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (tmp != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
