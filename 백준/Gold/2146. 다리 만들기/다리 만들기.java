import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    static int n;

    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visit;
    static int[][] numberMap;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        numberMap = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int number = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 &&!visit[i][j]){
                    bfs(number++,i,j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (numberMap[i][j] >0){
                    findMin(i, j);
                }
            }
        }
        System.out.println(result);

    }

    private static void findMin(int x, int y) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o->o[2]));
        int currentNumber = numberMap[x][y];
        q.add(new int[]{x, y, 0});
        boolean[][] visited = new boolean[n][n];
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int tx = tmp[0] + dx[i];
                int ty = tmp[1] + dy[i];
                if (tx<0 || ty<0 || tx>=n || ty>=n || visited[tx][ty]){
                    continue;
                }
                if (numberMap[tx][ty]>currentNumber){
                    result = Math.min(result, tmp[2]);
                    return;
                }
                if (map[tx][ty]==0){
                    visited[tx][ty] = true;
                    q.add(new int[]{tx, ty, tmp[2] + 1});
                }
            }
        }
    }

    private static void bfs(int number,int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        visit[x][y] = true;
        numberMap[x][y] =number;
        while (!q.isEmpty()){
            int[] tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int tx = tmp[0] + dx[i];
                int ty = tmp[1] + dy[i];
                if (tx<0 || ty<0 || tx>=n || ty>=n || visit[tx][ty] || map[tx][ty]==0){
                    continue;
                }
                visit[tx][ty] = true;
                q.add(new int[]{tx, ty});
                numberMap[tx][ty] = number;
            }
        }
    }


}