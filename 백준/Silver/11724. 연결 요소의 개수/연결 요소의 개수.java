import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int MOD = 1000000000;
    static int n;
    static int r;
    static int m;
    static int k;

    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static List<Integer>[] list;

    static int count = 0;
    static int[] visit;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new int[n + 1];
        list = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        for (int i = 1; i <= n; i++) {
            if (visit[i] == 0) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);

    }

    private static void dfs(int cur) {
        visit[cur] = 1;
        for (int i = 0; i < list[cur].size(); i++) {
            if (visit[list[cur].get(i)] == 1) {
                continue;
            }
            dfs(list[cur].get(i));
        }
    }


}