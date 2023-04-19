import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static List<Integer>[] nodes;
    static List<Integer>[] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nodes = new List[n + 1];
        tree = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(b);
            nodes[b].add(a);
        }
        makeTree(1);
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            find(a, b);
        }
        System.out.println(sb);
    }

    private static void find(int a, int b) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visit = new boolean[n + 1];
        if (a == b) {
            sb.append(a).append("\n");
            return;
        }
        q.add(a);
        q.add(b);
        while (!q.isEmpty()) {
            int tmp = q.poll();
            if (visit[tmp]) {
                sb.append(tmp).append("\n");
                return;
            }
            visit[tmp] = true;
            if (tmp == 1) {
                continue;
            }
            q.add(tree[tmp].get(0));
        }
    }

    private static void makeTree(int root) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visit = new boolean[n + 1];
        visit[root] = true;
        q.add(root);
        while (!q.isEmpty()) {
            int tmp = q.poll();

            for (Integer i : nodes[tmp]) {
                if (visit[i]) {
                    continue;
                }
                visit[i] = true;
                tree[i].add(tmp);
                q.add(i);
            }
        }
    }


}