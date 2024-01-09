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

    static long INF = Long.MAX_VALUE;
    static int n;
    static int r;
    static int m;
    static int k;
    static int x;
    static char[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<int[]>[] list;

    static int count = 0;
    static int[] arr2;
    static int[][] dp;
    static long[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visit = new long[n + 1];
        Arrays.fill(visit, INF);
        list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[b].add(new int[]{a, c});
        }
        st = new StringTokenizer(br.readLine());
        bfs(st);

        long result = 0;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (result < visit[i]) {
                result = visit[i];
                index = i;
            }
        }
        System.out.println(index);
        System.out.println(result);
    }

    private static void bfs(StringTokenizer st) {
        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        for (int i = 0; i < k; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            q.add(new long[]{tmp, 0});
            dist[tmp] = 0;
        }

        while (!q.isEmpty()) {
            long[] tmp = q.poll();
            if (dist[(int) tmp[0]] != tmp[1]) {
                continue;
            }
            for (int i = 0; i < list[(int) tmp[0]].size(); i++) {
                int[] next = list[(int) tmp[0]].get(i);

                if (dist[next[0]] > next[1] + tmp[1]) {
                    dist[next[0]] = next[1] + tmp[1];
                    q.add(new long[]{next[0], dist[next[0]]});
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            visit[i] = Math.min(visit[i], dist[i]);
        }
    }


}