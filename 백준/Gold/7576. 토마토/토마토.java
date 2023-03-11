import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[][] box;
    static Queue<int[]> tomatoes;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        tomatoes = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    tomatoes.add(new int[]{i, j, 0});
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int max = 0;
        while (!tomatoes.isEmpty()) {
            int[] tmp = tomatoes.poll();
            int x = tmp[0];
            int y = tmp[1];
            max = Math.max(max, tmp[2]);
            for (int i = 0; i < 4; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                if (tx < 0 || ty < 0 || tx >= N || ty >= M) {
                    continue;
                }
                if (box[tx][ty] == 0) {
                    tomatoes.add(new int[]{tx, ty, tmp[2] + 1});
                    box[tx][ty] = 1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    return -1;
                }
            }
        }
        return max;
    }

}