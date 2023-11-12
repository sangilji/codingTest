import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int n;
    static int r;
    static int m;
    static int k;
    static int x;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<int[]>[] list;

    static int count = 0;
    static int[] arr2;
    static int[][] dp;
    static int[] visit = new int[n + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        list = new List[n + 1];
        visit = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
        }
        for (int i = 1; i <= n; i++) {
            if (i != x) {
                bfs(i);
            }
        }
        bfs(x);

    }

    private static void bfs(int cur) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[cur] = 0;
        q.add(new int[]{cur, 0});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < list[tmp[0]].size(); i++) {
                int[] next = list[tmp[0]].get(i);
                if (dist[next[0]] > tmp[1] + next[1]) {
                    dist[next[0]] = tmp[1] + next[1];
                    q.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }
        visit[cur] = dist[x];
        if (cur == x) {
            int max = 0;
            for (int i = 1; i <= n; i++) {
                max = Math.max(visit[i] + dist[i], max);
            }
            System.out.println(max);
        }
    }


}