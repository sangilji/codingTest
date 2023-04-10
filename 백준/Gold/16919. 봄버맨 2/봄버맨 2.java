import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;
    static int n;
    static char[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        int count = 0;
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'O') {
                    count++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (count == 0) {
            if (n%4==1){
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        sb.append('.');
                    }
                    sb.append("\n");
                }
            } else {
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        sb.append('O');
                    }
                    sb.append("\n");
                }
            }
            System.out.println(sb);
            return;
        }

        if (n == 1) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        } else if (n % 2 == 0) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append('O');
                }
                sb.append("\n");
            }
        } else if (n % 4 == 1) {
            start();
            start();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        } else if (n % 4 == 3) {
            start();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void start() {
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'O') {
                    q.add(new int[]{i, j});
                } else {
                    map[i][j] = 'O';
                }
            }
        }
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            map[tmp[0]][tmp[1]] = '.';
            for (int i = 0; i < 4; i++) {
                int x = tmp[0] + dx[i];
                int y = tmp[1] + dy[i];
                if (x < 0 || y < 0 || x >= r || y >= c) {
                    continue;
                }
                map[x][y] = '.';
            }
        }

    }
}