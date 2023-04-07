import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[][] arr = new long[n + 1][n + 1];
        long[][] rowTree = new long[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                add(j, arr[i][j], rowTree[i]);
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
                int sum  = 0;
                for (int j = x1; j <= x2; j++) {
                    sum+= (sum(y2,rowTree[j]) - sum(y1-1,rowTree[j]));
                }
                sb.append(sum).append("\n");
            } else {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                long c = Integer.parseInt(st.nextToken());
                add(y,c-arr[x][y],rowTree[x]);
                arr[x][y] = c;
            }

        }
        System.out.println(sb);
    }

    public static void add(int i, long num, long[] tree) {
        while (i <= n) {
            tree[i] += num;
            i += (i & -i);
        }
    }

    public static long sum(int i, long[] tree) {
        long tmp = 0;
        while (i > 0) {
            tmp += tree[i];
            i -= (i & -i);
        }
        return tmp;
    }
}