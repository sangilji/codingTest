import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[][] arr = new long[n + 1][n + 1];
        tree = new long[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
                add(j, i, arr[i][j]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                long sum = sum(y2,x2) - sum(y2,x1-1) - sum(y1-1,x2) + sum(y1-1,x1-1);
                sb.append(sum).append("\n");
            } else {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                long c = Integer.parseInt(st.nextToken());
                add(y,x, c - arr[x][y]);
                arr[x][y] = c;
            }

        }
        System.out.println(sb);
    }

    public static void add(int y, int x, long num) {
        for (int j = y; j <= n; j += (j & -j)) {
            for (int k = x; k <= n; k += (k & -k)) {
                tree[j][k] += num;
            }
        }
    }

    public static long sum(int y, int x) {
        long tmp = 0;
        for (int i = y; i > 0; i -= (i & -i)) {
            for (int j = x; j > 0; j -= (j & -j)) {
                tmp += tree[i][j];
            }
        }
        return tmp;
    }
}