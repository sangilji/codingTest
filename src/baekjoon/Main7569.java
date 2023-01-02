package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main7569 {
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int M;
    static int N;
    static int H;
    static int[][][] box;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        M = s.nextInt();
        N = s.nextInt();
        H = s.nextInt();
        box = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = s.nextInt();
                    if (box[i][j][k] == 1) {
                        q.add(new int[]{i, j, k});
                    }
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int day = 1;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 6; i++) {
                int x = tmp[1] + dx[i];
                int y = tmp[2] + dy[i];
                int z = tmp[0] + dz[i];
                if (x < 0 || y < 0 || z < 0 || x >= N || y >= M || z >= H || box[z][x][y] != 0) {
                    continue;
                }
                box[z][x][y] = box[tmp[0]][tmp[1]][tmp[2]] + 1;
                day = Math.max(day, box[z][x][y]);
                q.add(new int[]{z, x, y});
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }
        return day - 1;
    }
}
