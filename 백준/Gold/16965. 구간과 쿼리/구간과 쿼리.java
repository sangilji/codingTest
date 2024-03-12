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

    static int[][] arr;
    static int sum;
    static int[] visit;
    static int[] price;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static int[][] arr1;
    static int count = 0;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<int[]> list;

    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        list.add(new int[]{0, 0});
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                list.add(new int[]{b, c});
            } else {
                visit = new int[n + 1];
                sb.append(dfs(b, c)).append("\n");

            }
        }
        System.out.println(sb);

    }

    private static int dfs(int a, int b) {
        visit[a] = 1;
        if (a == b) {
            return 1;
        }
        int tmp = 0;
        for (int i = 1; i < list.size(); i++) {
            if (visit[i] == 1) {
                continue;
            }
            if ((list.get(i)[0] < list.get(a)[0] && list.get(a)[0] < list.get(i)[1]) || (list.get(i)[0] < list.get(a)[1]
                    && list.get(a)[1] < list.get(i)[1])) {
                tmp |= dfs(i, b);
            }
        }
        return tmp;
    }


}