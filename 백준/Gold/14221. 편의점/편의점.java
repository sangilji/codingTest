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

    static int INF = 1_000_000_007;
    static int MOD = 1_000_000_007;
    static int n;
    static int m;

    static int[][] arr;
    static List<int[]>[] list;
    static int[] dx = {1, 0, 1, 1};
    static int[] dy = {1, 1, 0, -1};

    static long count = 0;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] house = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            house[i] = Integer.parseInt(st.nextToken());
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < l; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            dist[tmp] = 0;
            q.add(new int[]{tmp, 0});
        }

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            if (tmp[1] != dist[tmp[0]]) {
                continue;
            }
            for (int i = 0; i < list[tmp[0]].size(); i++) {
                int[] next = list[tmp[0]].get(i);
                if (tmp[1] + next[1] < dist[next[0]]) {
                    dist[next[0]] = tmp[1] + next[1];
                    q.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }
        Arrays.sort(house);

        int result = INF;
        int index = 0;
        for (int i = 0; i < k; i++) {
            if (dist[house[i]] < result) {
                result = dist[house[i]];
                index = house[i];
            }
        }
        System.out.println(index);
    }


}