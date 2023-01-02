package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1260 {
    private static boolean[] visit;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        visit = new boolean[n + 1];
        int v = s.nextInt();
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            arr[a][b] = arr[b][a] = 1;
        }
        visit[v] = true;
        dfs(arr, v);
        System.out.println();
        visit = new boolean[n + 1];
        bfs(arr, v);
    }

    private static void dfs(int[][] arr, int v) {
        System.out.print(v + " ");
        for (int i = 1; i < arr[v].length; i++) {
            if (arr[v][i] == 0 || visit[i]) {
                continue;
            }
            visit[i] = true;
            dfs(arr, i);
        }
    }

    private static void bfs(int[][] arr, int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visit[v] = true;

        while (!q.isEmpty()) {
            int tmp = q.poll();
            System.out.print(tmp + " ");
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
