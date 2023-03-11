import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    static List<Node>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        nodes = new List[v + 1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            nodes[a].add(new Node(b, cost));
        }

        dijk(k);
    }

    private static void dijk(int k) {
        int INF = Integer.MAX_VALUE;
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        int[] dist = new int[nodes.length];
        boolean[] visit = new boolean[nodes.length];
        Arrays.fill(dist, INF);
        dist[k] = 0;
        q.add(new Node(k, 0));
        while (!q.isEmpty()) {
            int tmp = q.poll().index;

            if (visit[tmp]) {
                continue;
            }
            visit[tmp] = true;
            for (Node next : nodes[tmp]) {
                if (dist[next.index] > dist[tmp] + next.cost){
                    dist[next.index] = dist[tmp] + next.cost;

                    q.add(new Node(next.index, dist[next.index]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == INF){
                sb.append("INF");
            } else{
                sb.append(dist[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}