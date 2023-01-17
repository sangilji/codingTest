import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static boolean[] visit;
    static int count = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int computer = s.nextInt();
        int network = s.nextInt();
        map = new int[computer + 1][computer + 1];
        visit = new boolean[computer + 1];
        for (int i = 0; i < network; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            map[a][b] = map[b][a] = 1;
        }
        bfs(1);
        System.out.println(count);
    }

    private static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visit[i] = true;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int j = 1; j < map.length; j++) {
                if (map[tmp][j] == 1 && !visit[j]) {
                    q.add(j);
                    visit[j] = true;
                    count++;
                }
            }
        }
    }
}
