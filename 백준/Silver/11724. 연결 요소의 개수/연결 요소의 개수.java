import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] graph;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        graph = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            graph[a][b] = graph[b][a] = 1;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                bfs(i);
                count++;
            }
        }
        System.out.println(count);

    }

    private static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int i = 1; i < graph.length; i++) {
                if (graph[tmp][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
