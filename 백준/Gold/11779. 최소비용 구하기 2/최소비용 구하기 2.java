import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int destination;
        int cost;

        public Node(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }

    static List<Node>[] nodes;

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nodes = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
        }
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            nodes[a].add(new Node(b, cost));
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        dijkstra(a, b, n);
    }

    private static void dijkstra(int a, int b, int n) {
        int[] dist = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        int[] count = new int[n + 1];
        Arrays.fill(dist, 100_000_000);
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        q.add(new Node(a, 0));
        dist[a] = 0;
        count[a] = a;
        while (!q.isEmpty()) {

            int currentIndex = q.poll().destination;
            if (visit[currentIndex]) {
                continue;
            }
            visit[currentIndex] = true;
            for (int i = 0; i < nodes[currentIndex].size(); i++) {
                Node next = nodes[currentIndex].get(i);
                if (dist[next.destination] > next.cost + dist[currentIndex]) {
                    dist[next.destination] = next.cost + dist[currentIndex];

                    count[next.destination] = currentIndex;
                    q.add(new Node(next.destination, dist[next.destination]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dist[b]).append("\n");
        Stack<Integer> s = new Stack<>();
        int tmp = b;
        while (true) {
            if (tmp == count[tmp]) {
                s.push(tmp);
                break;
            }
            s.push(tmp);
            tmp = count[tmp];
        }
        sb.append(s.size()).append("\n");
        while (!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }
        System.out.println(sb);

    }
}
