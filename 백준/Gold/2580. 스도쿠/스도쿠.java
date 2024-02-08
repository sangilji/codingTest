import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_009;
    static int n;
    static int m;
    static int k;

    static int[][] arr;
    static int[] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr1;
    static int count = 0;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = 9;
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0, 0);
    }

    static boolean b = false;

    private static void recur(int x, int y) {
        if (b) {
            return;
        }
        if (y == 9) {
            x += 1;
            y = 0;
        }
        if (x == 9) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            b = true;
            return;
        }

        if (arr[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(x, y, i)) {
                    arr[x][y] = i;
                    recur(x, y + 1);
                    arr[x][y] = 0;
                }
            }
        } else {
            recur(x, y + 1);
        }

    }

    private static boolean check(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (arr[x][i] == num || arr[i][y] == num) {
                return false;
            }
        }

        int row = (x / 3) * 3;
        int col = (y / 3) * 3;

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (arr[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }


}