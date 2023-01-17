import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int max;

    static class Node {
        int child;
        int cost;

        public Node(int child, int cost) {
            this.child = child;
            this.cost = cost;
        }
    }

    static ArrayList<Node>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nodes = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            nodes[a].add(new Node(b, cost));
            nodes[b].add(new Node(a, cost));
        }


        int result = dijk(1, n);
        dijk(result, n);
        System.out.println(max);
    }

    private static int dijk(int i, int n) {
        boolean[] visit = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        q.add(new Node(i, 0));
        dist[i] = 0;
        while (!q.isEmpty()) {

            int tmp = q.poll().child;
            if (visit[tmp]) {
                continue;
            }
            visit[tmp] = true;

            for (Node next : nodes[tmp]) {
                if (dist[next.child] > dist[tmp] + next.cost) {
                    dist[next.child] = dist[tmp] + next.cost;

                    q.add(new Node(next.child, dist[next.child]));
                }
            }
        }
        max = Arrays.stream(dist)
                .filter(d -> d != Integer.MAX_VALUE)
                .max()
                .getAsInt();
        for (int j = 1; j < dist.length; j++) {
            if (dist[j] == max) {
                return j;
            }
        }
        return 0;
    }


}
