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
    static final int INF = 1_000_000_000;
    static int n;
    static int m;
    static List<int[]>[] list;
    static int[] parent;
    static int[] score;
    static int[] cards;
    static int[] depth;
    static int[] sz;
    static int[] visit;
    static long count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        bfs(a, b);


    }

    private static void bfs(int a, int b) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[a] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        q.add(new int[]{a, 0});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (dist[tmp[0]] != tmp[1]) {
                continue;
            }
            for (int i = 0; i < list[tmp[0]].size(); i++) {
                int[] next = list[tmp[0]].get(i);
                if (dist[next[0]] > next[1] + dist[tmp[0]]) {
                    dist[next[0]] = next[1] + dist[tmp[0]];
                    q.add(new int[]{next[0], next[1] + dist[tmp[0]]});
                }
            }
        }
        System.out.println(dist[b]);
    }


}