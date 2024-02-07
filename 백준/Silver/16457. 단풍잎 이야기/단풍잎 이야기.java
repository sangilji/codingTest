import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_009;
    static int n;
    static int m;
    static int k;

    static int[][] arr;
    static int[] visit;
    static int[] dx = {1, 0, 1, 1};
    static int[] dy = {1, 1, 0, -1};
    static int[][] arr1;
    static int count = 0;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[m][k];
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                s.add(arr[i][j]);
            }
        }
        list = new ArrayList<>(s);
        visit = new int[n * 2 + 1];
        recur(0, 0);
        System.out.println(result);

    }

    static int result = 0;

    private static void recur(int depth, int keyCount) {
        if (depth == list.size()) {
            if (keyCount > n) {
                return;
            }
            check();
            return;
        }

        visit[list.get(depth)] = 1;
        recur(depth + 1, keyCount + 1);
        visit[list.get(depth)] = 0;
        recur(depth + 1, keyCount);
    }

    private static void check() {
        int count = 0;

        for (int i = 0; i < m; i++) {
            boolean b = true;
            for (int j = 0; j < k; j++) {
                if (visit[arr[i][j]] == 0) {
                    b = false;
                    break;
                }
            }
            if (b) {
                count++;
            }
        }
        result = Math.max(result, count);
    }


}