package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main1227 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] start;
    static int[] last;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int t = Integer.parseInt(br.readLine());
            int[][] map = new int[100][100];
            start = new int[2];
            last = new int[2];
            for (int i = 0; i < 100; i++) {
                String num = br.readLine();
                for (int j = 0; j < 100; j++) {
                    map[i][j] = num.charAt(j) - '0';
                    if (map[i][j] == 2) {
                        start[0] = i;
                        start[1] = j;
                    }
                    if (map[i][j] == 3) {
                        last[0] = i;
                        last[1] = j;
                    }
                }
            }
            System.out.printf("#%d %d\n", t, bfs(map));
        }
    }

    private static int bfs(int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1]});
        map[start[0]][start[1]] = 1;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[0] == last[0] && tmp[1] == last[1]) {
                return 1;
            }
            for (int i = 0; i < 4; i++) {
                int x = tmp[0] + dx[i];
                int y = tmp[1] + dy[i];
                if (x < 0 || y < 0 || x >= map.length || y >= map.length || map[x][y] == 1) {
                    continue;
                }
                map[x][y] = 1;
                q.add(new int[]{x, y});
            }
        }
        return 0;
    }
}
