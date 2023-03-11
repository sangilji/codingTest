import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visit;
    static int[][] number;
    static Map<Integer, Integer> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        number = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] tmp =br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        int num = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j]==0 && !visit[i][j]){
                    bfs(i,j,num++);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j]!=0){
                    map[i][j] = (map[i][j] +check(i, j))%10;
                }
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int check(int x, int y) {
        Set<Integer> s = new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(number[i][j]);
//            }
//            System.out.println();
//        }
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (tx<0 || ty<0 || tx>=n || ty>= m || number[tx][ty]==0){
                continue;
            }
            s.add(number[tx][ty]);
        }
//        System.out.println(s);
        for (Integer i : s) {
            count+=hm.get(i);
        }
        return count;
    }

    private static void bfs(int x, int y, int num) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        number[x][y] = num;
        visit[x][y] = true;
        int count = 1;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int tx = tmp[0] + dx[i];
                int ty = tmp[1] + dy[i];
                if (tx<0 || ty<0 || tx>=n || ty>= m || map[tx][ty]>0 || visit[tx][ty]){
                    continue;
                }
                count++;
                visit[tx][ty] = true;
                number[tx][ty] = num;
                q.add(new int[]{tx, ty});

            }
        }
        hm.put(num, count);
    }
}