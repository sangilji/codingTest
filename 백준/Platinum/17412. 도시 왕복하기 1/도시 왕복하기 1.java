import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static List<Integer>[] nodes;
    static int n;
    static int[][] capacity;
    static int[][] flow;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        capacity = new int[n + 1][n + 1];
        flow = new int[n + 1][n + 1];
        int p = Integer.parseInt(st.nextToken());
        nodes = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(b);
            nodes[b].add(a);
            capacity[a][b] = 1;
        }

        bfs();
    }

    private static void bfs() {
        long cnt = 0;
        while (true) {
            int[] parent = new int[n + 1];
            Arrays.fill(parent, -1);
            Queue<Integer> q = new ArrayDeque<>();
            parent[1] = 1;
            q.add(1);

            while (!q.isEmpty() && parent[2] == -1) {
                int tmp = q.poll();
                for (int i : nodes[tmp]) {
                    if (capacity[tmp][i] - flow[tmp][i] > 0 && parent[i] == -1) {
                        q.add(i);
                        parent[i] = tmp;
                    }
                }
            }
            if (parent[2] == -1) {
                break;
            }

            int minFlow = Integer.MAX_VALUE;
            for (int i = 2; i != 1; i = parent[i]) {
                minFlow = Math.min(minFlow, capacity[parent[i]][i] - flow[parent[i]][i]);
            }
            for (int i = 2; i != 1; i = parent[i]) {
             flow[parent[i]][i] += minFlow;
             flow[i][parent[i]] -= minFlow;
            }

            cnt+=minFlow;
        }
        System.out.println(cnt);
    }
}