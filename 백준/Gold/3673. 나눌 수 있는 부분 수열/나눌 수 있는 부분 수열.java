import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_007;
    static int n;
    static int r;
    static int m;
    static int c;
    static int x;
    static int[] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<int[]>[] list;

    static long count = 0;
    static int[] arr2;
    static int[][] dp;
    static long[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[m + 1];
            int[] division = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= m; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long sum = 0;
            long count = 0;
            for (int i = 1; i <= m; i++) {
                sum += arr[i];
                if (sum % n == 0) {
                    count++;
                }
                count += division[(int) (sum % n)];
                division[(int) (sum % n)]++;
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}