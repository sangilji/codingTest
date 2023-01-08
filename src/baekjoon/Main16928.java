package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main16928 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n + m; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            map.put(a, b);
        }
        bfs(map);
    }

    private static void bfs(Map<Integer, Integer> map) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o2[1] == o1[1]) {
                return o2[0] - o1[0];
            }
            return o1[1] - o2[1];
        });
        boolean[] visit = new boolean[101];
        q.add(new int[]{1, 0});
        visit[1] = true;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[0] == 100) {
                System.out.println(tmp[1]);
                return;
            }
            for (int i = 1; i <= 6; i++) {
                int x = tmp[0] + i;
                if (map.containsKey(x)) {
                    visit[x] = true;
                    x = map.get(x);
                }
                if (x > 100 || visit[x]) {
                    continue;
                }
                visit[x] = true;
                q.add(new int[]{x, tmp[1] + 1});
            }
        }
    }
}