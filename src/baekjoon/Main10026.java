package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main10026 {
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        String[][] picture = new String[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < picture.length; i++) {
            picture[i] = s.next().split("");
        }

        int[] count = new int[2];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (!visit[i][j]) {
                    visit[i][j] = true;
                    bfs(picture, i, j);
                    count[0]++;

                }

            }
        }
        visit = new boolean[N][N];

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j].equals("G")) {
                    picture[i][j] = "R";
                }

            }
        }

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (!visit[i][j]) {
                    visit[i][j] = true;
                    bfs(picture, i, j);
                    count[1]++;
                }

            }
        }
        System.out.println(count[0] + " " + count[1]);
    }

    private static void bfs(String[][] picture, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        String color = picture[x][y];
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int tmpX = dx[i] + tmp[0];
                int tmpY = dy[i] + tmp[1];
                if (tmpX < 0 || tmpX >= picture.length || tmpY < 0 || tmpY >= picture.length
                        || !picture[tmpX][tmpY].equals(color) || visit[tmpX][tmpY]) {
                    continue;
                }
                visit[tmpX][tmpY] = true;
                q.add(new int[]{tmpX, tmpY});
            }
        }

    }
}
