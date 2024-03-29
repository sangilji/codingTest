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

    static int[] arr;
    static int sum;
    static int[] visit;
    static int[] parent;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr1;
    static int count = 0;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<Integer>[] list;
    static List<Integer>[] list2;

    static int[] result;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        list = new List[n + 1];
        visit = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        dfs(1);
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);

    }

    private static void dfs(int cur) {
        visit[cur] = 1;

        for (int i = 0; i < list[cur].size(); i++) {
            if (visit[list[cur].get(i)] == 1) {
                continue;
            }
            parent[list[cur].get(i)] = cur;
            dfs(list[cur].get(i));
        }
    }


}