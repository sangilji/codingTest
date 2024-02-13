import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_009;
    static int n;
    static int m;
    static int k;

    static int[] arr;
    static int[] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr1;
    static int count = INF;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<int[]>[] list;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        list = new List[n + 1];
        visit = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            m = Integer.parseInt(br.readLine());
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[i].add(new int[]{a, b});
            }
        }
        recur(0, 0);
        System.out.println(count);

    }

    private static void recur(int depth, int sum) {
        if (depth == n) {
            count = Math.min(sum, count);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visit[i] == 1) {
                continue;
            }
            visit[i] = 1;
            for (int[] j : list[i]) {
                arr[j[0]] -= j[1];
            }
            recur(depth + 1, sum + Math.max(arr[i], 1));
            visit[i] = 0;
            for (int[] j : list[i]) {
                arr[j[0]] += j[1];
            }
        }

    }


}