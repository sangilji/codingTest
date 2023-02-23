import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private static boolean[] visit;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];
        int v = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        visit[v] = true;
        dfs(v);
        sb.append("\n");
        visit = new boolean[n + 1];
        bfs(v);
        System.out.println(sb);
    }

    private static void dfs(int v) {
        sb.append(v).append(" ");
        for (int i = 1; i < arr[v].length; i++) {
            if (arr[v][i] == 0 || visit[i]) {
                continue;
            }
            visit[i] = true;
            dfs(i);
        }
    }

    private static void bfs( int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visit[v] = true;

        while (!q.isEmpty()) {
            int tmp = q.poll();
            sb.append(tmp).append(" ");
            for (int i = 1; i < arr[tmp].length; i++) {
                if (arr[tmp][i] == 0 || visit[i]) {
                    continue;
                }
                visit[i] = true;
                q.add(i);
            }
        }
    }
}