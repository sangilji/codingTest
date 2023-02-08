import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int a;
        int b;
        int cost;

        public Node(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Node> nodes = new ArrayList<>();
        List<Integer>[] result = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            result[i] = new ArrayList<>();
        }
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = i + 1; j < n + 1; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                nodes.add(new Node(i, j, tmp));
            }
        }
        nodes.sort(Comparator.comparingInt(node -> node.cost));
        for (int i = 0; i < nodes.size(); i++) {
            int a = check(nodes.get(i).a);
            int b = check(nodes.get(i).b);
            if (a != b) {
                if (a < b) {
                    parent[b] = a;
                } else {
                    parent[a] = b;
                }
                result[nodes.get(i).a].add(nodes.get(i).b);
                result[nodes.get(i).b].add(nodes.get(i).a);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < result.length; i++) {
            sb.append(result[i].size()).append(" ");
            result[i].sort(Integer::compareTo);
            for (int j = 0; j < result[i].size(); j++) {
                sb.append(result[i].get(j)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int check(int i) {
        if (i == parent[i]) {
            return i;
        }

        return check(parent[i]);
    }
}