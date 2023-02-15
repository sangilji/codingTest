import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static int n;
    static int m;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] commands = Arrays.stream(br.readLine()
                        .split(" "))
                .mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < r; i++) {
            if (commands[i] == 1) {
                cal1();
            }
            if (commands[i] == 2) {
                cal2();
            }
            if (commands[i] == 3) {
                cal3();
            }
            if (commands[i] == 4) {
                cal4();
            }
            if (commands[i] == 5) {
                cal5();
            }
            if (commands[i] == 6) {
                cal6();
            }
        }

        print();
    }

    private static void cal1() {
        int[][] tmp = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                tmp[n + 1 - i][j] = arr[i][j];
            }
        }
        arr = tmp;
    }

    private static void cal2() {
        int[][] tmp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                tmp[i][m + 1 - j] = arr[i][j];
            }
        }
        arr = tmp;
    }

    private static void cal3() {
        int[][] tmp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                tmp[i][j] = arr[n + 1 - j][i];
            }
        }
        int t = n;
        n = m;
        m = t;
        arr = tmp;
    }

    private static void cal4() {
        int[][] tmp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                tmp[i][j] = arr[j][m + 1 - i];
            }
        }
        int t = n;
        n = m;
        m = t;
        arr = tmp;
    }

    private static void cal5() {
        int[][] tmp = new int[n + 1][m + 1];

        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; j <= m / 2; j++) {
                tmp[i][m / 2 + j] = arr[i][j];
            }
        }

        for (int i = 1; i <= n / 2; i++) {
            for (int j = m / 2 + 1; j < m + 1; j++) {
                tmp[n / 2 + i][j] = arr[i][j];
            }
        }

        for (int i = n / 2 + 1; i < n + 1; i++) {
            int c = 1;
            for (int j = m / 2 + 1; j < m + 1; j++) {
                tmp[i][c++] = arr[i][j];
            }
        }
        int row = 1;
        for (int i = n / 2 + 1; i < n + 1; i++) {
            for (int j = 0; j <= m / 2; j++) {
                tmp[row][j] = arr[i][j];
            }
            row++;
        }
        arr = tmp;
    }

    private static void cal6() {
        int[][] tmp = new int[n + 1][m + 1];

        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; j <= m / 2; j++) {
                tmp[i + n / 2][j] = arr[i][j];
            }
        }

        for (int i = n / 2 + 1; i < n + 1; i++) {
            for (int j = 1; j <= m / 2; j++) {
                tmp[i][j + m / 2] = arr[i][j];
            }
        }

        int row = 1;
        for (int i = n / 2 + 1; i < n + 1; i++) {
            for (int j = m / 2 + 1; j < m + 1; j++) {
                tmp[row][j] = arr[i][j];
            }
            row++;
        }

        for (int i = 1; i <= n / 2; i++) {
            int c = 0;
            for (int j = m / 2; j < m + 1; j++) {
                tmp[i][c++] = arr[i][j];
            }
        }

        arr = tmp;
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}