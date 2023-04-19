import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static List<Integer>[] nodes;
    static int[] depth;
    static int[][] parent;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nodes = new List[n + 1];
        depth = new int[n + 1];
        k = 0;
        for (int i = 1; i <= n; i *= 2) {
            k++;
        }
        parent = new int[k][n + 1];
        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(b);
            nodes[b].add(a);
        }
        makeDepth(1);
        makeParent();
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            find(a, b);
        }
        System.out.println(sb);
    }

    private static void makeParent() {
        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }
    }

    private static void find(int a, int b) {
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        for (int i = k - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                a = parent[i][a];
            }
        }

        if (a == b) {
            sb.append(a).append("\n");
            return;
        }

        for (int i = k - 1; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        sb.append(parent[0][a]).append("\n");
    }

    private static void makeDepth(int root) {
        Queue<Integer> q = new ArrayDeque<>();
        depth[root] = 1;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int tmp = q.poll();
                for (Integer j : nodes[tmp]) {
                    if (depth[j] != 0) {
                        continue;
                    }
                    parent[0][j] = tmp;
                    depth[j] = depth[tmp] + 1;
                    q.add(j);
                }
            }
        }
    }


}