import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            int x = 1;
            int y = 1;
            while (x <= n / 2 && y <= m / 2) {
                int tmp = arr[x][y];
                for (int j = y; j < m + 1 - y; j++) {
                    arr[x][j] = arr[x][j + 1];
                }

                for (int j = x; j < n + 1 - x; j++) {
                    arr[j][m + 1 - y] = arr[j + 1][m + 1 - y];
                }

                for (int j = m + 1 - y; j > y; j--) {
                    arr[n + 1 - x][j] = arr[n + 1 - x][j - 1];
                }

                for (int j = n + 1 - y; j > x + 1; j--) {
                    arr[j][y] = arr[j-1][y];
                }

                arr[x + 1][y] = tmp;
                x++;
                y++;
            }

        }
        print(arr);
    }

    private static void print(int[][] arr) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}