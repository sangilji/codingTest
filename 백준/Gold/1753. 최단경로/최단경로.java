import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int last;
        int cost;

        public Node(int last, int cost) {
            this.last = last;
            this.cost = cost;
        }
    }

    static int K;
    static List<List<Node>> nodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < V + 1; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodes.get(u).add(new Node(v, w));
        }

        bfs();

    }

    public static void bfs() {
        int[] dist = new int[nodes.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visit = new boolean[nodes.size()];
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        q.add(new Node(K, 0));
        dist[K] = 0;

        while (!q.isEmpty()) {
            int tmp = q.poll().last;

            if (visit[tmp]){
                continue;
            }
            visit[tmp]=true;
            for (int i = 0; i < nodes.get(tmp).size(); i++) {
                Node currentNode = nodes.get(tmp).get(i);

                if(dist[currentNode.last] > currentNode.cost + dist[tmp]){
                    dist[currentNode.last] = currentNode.cost + dist[tmp];
                    q.add(new Node(currentNode.last, dist[currentNode.last]));
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < nodes.size(); i++) {
            if (dist[i] == Integer.MAX_VALUE){
                sb.append("INF\n");
            }else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}