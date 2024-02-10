import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
    static int count = 1000;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<Integer> list;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        result = new int[m + 1];
        Arrays.fill(result, 1000);
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            int index = 0;
            for (char c : tmp[1].toCharArray()) {
                arr[i][index++] = c == 'Y' ? 1 : 0;
            }
        }
        visit = new int[m];
        recur(0, 0);
        for (int i = m; i > 0; i--) {
            if (result[i] != 1000) {
                System.out.println(result[i]);
                return;
            }
        }
        System.out.println(-1);

    }

    private static void recur(int depth, int sum) {
        if (depth == n) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (visit[i] > 0) {
                    count++;
                }
            }
            result[count] = Math.min(sum, result[count]);
            return;
        }
        for (int i = 0; i < m; i++) {
            if (arr[depth][i] == 1) {
                visit[i]++;
            }
        }
        recur(depth + 1, sum + 1);
        for (int i = 0; i < m; i++) {
            if (arr[depth][i] == 1) {
                visit[i]--;
            }
        }
        recur(depth + 1, sum);
    }


}