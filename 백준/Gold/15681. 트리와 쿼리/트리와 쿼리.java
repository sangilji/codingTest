import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int INF = 1_000_000_000;
    static int n;
    static int m;
    static int k;
    static int str;
    static int[] arr;
    static int[] tree;
    static int[] treeMaxIndex;
    static int[] dx = {1, 0, -1, 0};

    static int[] dy = {0, 1, 0, -1};
    static int[][] dp;
    static List<Integer>[] list;
    static List<int[]>[] list2;
    static int[] visit;
    static int[] sz;
    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new List[n + 1];
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
        visit = new int[n + 1];
        sz = new int[n + 1];
        dfs(m);
        for (int i = 0; i < k; i++) {
            int tmp = Integer.parseInt(br.readLine());
            sb.append(sz[tmp]).append("\n");
        }
        System.out.println(sb);

    }

    private static void dfs(int cur) {
        visit[cur]  =1;
        sz[cur]=1;
        for (int i = 0; i < list[cur].size(); i++) {
            if (visit[list[cur].get(i)]==1) {
                continue;
            }
            dfs(list[cur].get(i));
            sz[cur] += sz[list[cur].get(i)];
        }
    }


}