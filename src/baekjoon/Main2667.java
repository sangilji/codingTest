package baekjoon;

import java.util.*;

public class Main2667 {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        map = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String m = s.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = m.charAt(j) - '0';
            }
        }
        List<Integer> arr = new ArrayList<>();
        int count = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    arr.add(bfs(i, j, count));
                    count++;
                }
            }
        }
        arr.sort(Integer::compareTo);
        System.out.println(arr.size());
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static int bfs(int x, int y, int count) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        int result = 0;
        map[x][y] = count;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            result++;
            for (int i = 0; i < 4; i++) {
                int tx = dx[i] + tmp[0];
                int ty = dy[i] + tmp[1];
                if (tx < 0 || ty < 0 || tx >= map.length || ty >= map.length || map[tx][ty] != 1) {
                    continue;
                }
                map[tx][ty] = count;
                q.add(new int[]{tx, ty});
            }

        }
        return result;
    }
}
