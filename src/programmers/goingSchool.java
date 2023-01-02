package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class goingSchool {
    static int min;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] b;
    static int count = 0;

    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2, 2}}));
    }

    public static int solution(int m, int n, int[][] puddles) {

        b = new boolean[n + 1][m + 1];
        for (int i = 0; i < puddles.length; i++) {
            b[puddles[i][0]][puddles[i][1]] = true;
        }
        min = bfs(n, m);
        b = new boolean[n + 1][m + 1];
        for (int i = 0; i < puddles.length; i++) {
            b[puddles[i][0]][puddles[i][1]] = true;
        }
        b[1][1] = true;
        dfs(1, 1, 0);
        return count;
    }

    private static void dfs(int x, int y, int depth) {
        if (depth == min) {
            if (x == b.length && y == b[0].length) {
                count++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (tx <= 0 || ty <= 0 || tx > b.length || ty > b[0].length || b[tx][ty]) {
                continue;
            }
            b[tx][ty] = true;
            dfs(tx, ty, depth + 1);
            b[tx][ty] = false;
        }

    }

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 1, 0});
        int count = 0;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[0] == x && tmp[1] == y) {
                count++;
                int min = tmp[2];
                while (!q.isEmpty()) {
                    int[] t = q.poll();
                    if (min == t[2]) {
                        count++;
                    } else {
                        break;
                    }
                }
                return count;
            }
            for (int i = 0; i < 4; i++) {
                int tX = tmp[0] + dx[i];
                int tY = tmp[1] + dy[i];
                if (tX < 0 || tY < 0 || tX > x || tY > y || b[tX][tY]) {
                    continue;
                }
                b[tX][tY] = true;
                q.add(new int[]{tX, tY, tmp[2] + 1});
            }
        }
        return 1;
    }

}
