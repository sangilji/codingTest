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
    static int[][] arr;
    static int[] tree;
    static int[] treeMaxIndex;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static long[] dp;
    static List<int[]>[] list;
    static List<int[]>[] list2;
    static int[] visit;
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
            list[a].add(new int[] {b, c});
            list2[b].add(new int[] {a, c});
        }
        int[] tmp1 = dijk(list);
        int[] tmp2 = dijk(list2);
        for (int i = 1; i <=n; i++) {
            count = Math.max(count, tmp1[i] + tmp2[i]);
        }
        System.out.println(count);
    }

    private static int[] dijk(List<int[]>[] list) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[k] = 0;
        q.add(new int[]{k, 0});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            if (tmp[1] != dist[tmp[0]]) {
                continue;
            }

            for (int i = 0; i < list[tmp[0]].size(); i++) {
                int[] next = list[tmp[0]].get(i);
                if (dist[next[0]] > tmp[1] + next[1]) {
                    dist[next[0]] = tmp[1] + next[1];
                    q.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }
        return dist;
    }

}