import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<int[]>[] nodes;
    static int n;
    static int q;
    static int[] number;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        nodes = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            nodes[a].add(new int[]{b, u});
            nodes[b].add(new int[]{a, u});
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int bfs = bfs(k, v);
            sb.append(bfs).append("\n");
        }
        System.out.println(sb);

    }

    private static int bfs(int k, int v) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{v, Integer.MAX_VALUE});
        boolean[] visit = new boolean[n + 1];
        int count = 0;
        visit[v] = true;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < nodes[tmp[0]].size(); i++) {
                int[] next = nodes[tmp[0]].get(i);
                if (visit[next[0]] || next[1] < k) {
                    continue;
                }
                visit[next[0]] = true;
                q.add(new int[]{next[0], Math.min(tmp[1], next[1])});
                count++;
            }
        }
        return count;
    }

}