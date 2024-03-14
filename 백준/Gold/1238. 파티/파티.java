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
    static int MOD = 1_000_000_009;
    static int n;
    static int m;
    static int k;

    static int[][] arr;
    static int sum;
    static int[] visit;
    static int[] price;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr1;
    static int count = 0;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<int[]>[] list;
    static List<int[]>[] list2;

    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        list = new List[n + 1];
        list2 = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
            list2[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
            list2[b].add(new int[]{a, c});
        }
        visit = new int[n + 1];
        bfs(list, x);
        bfs(list2, x);


    }

    private static void bfs(List<int[]>[] list, int start) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        q.add(new int[]{start, 0});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (dist[tmp[0]] != tmp[1]) {
                continue;
            }
            for (int i = 0; i < list[tmp[0]].size(); i++) {
                int[] next = list[tmp[0]].get(i);
                if (dist[next[0]] > next[1] + tmp[1]) {
                    dist[next[0]] = next[1] + tmp[1];
                    q.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }
        if (visit[0] == 0) {
            visit = dist;
        } else {
            int max = 0;
            for (int i = 1; i <= n; i++) {
                max = Math.max(visit[i] + dist[i], max);
            }
            System.out.println(max);
        }

    }


}