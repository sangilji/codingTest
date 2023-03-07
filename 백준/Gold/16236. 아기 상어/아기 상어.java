import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static int sharkSize = 2;
    static int sharkCount = 0;
    static int sharkX;
    static int sharkY;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j]==9){
                    sharkX = i;
                    sharkY = j;
                }
            }
        }
        start();
        System.out.println(count);
    }

    private static void start() {

        while(true){
            if(!check()){
                break;
            }
        }
    }

    private static boolean check() {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o1[2]== o2[2]){
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
            return o1[2] -o2[2];
        });
        boolean[][] visit = new boolean[n][n];
        Queue<int[]> bfsQ = new ArrayDeque<>();
        bfsQ.add(new int[]{sharkX, sharkY,0});
        visit[sharkX][sharkY] = true;
        while (!bfsQ.isEmpty()) {
            int[] tmp = bfsQ.poll();

            for (int i = 0; i < 4; i++) {
                int x = tmp[0] + dx[i];
                int y = tmp[1] + dy[i];
                if (x<0 || y<0 || x>=n || y>=n || visit[x][y] || map[x][y]>sharkSize){
                    continue;
                }
                if (map[x][y]!=0 && map[x][y]<sharkSize){
                    q.add(new int[]{x, y, tmp[2] + 1});
                }
                visit[x][y] = true;
                bfsQ.add(new int[]{x, y, tmp[2] + 1});
            }
        }
        if (q.isEmpty()){
            return false;
        }

        int[] tmp = q.poll();
        move(tmp);

        return true;
    }

    private static void move(int[] tmp) {
        map[sharkX][sharkY] = 0;
        sharkX = tmp[0];
        sharkY = tmp[1];
        map[sharkX][sharkY] = 9;
        sharkCount++;
        if (sharkCount==sharkSize){
            sharkSize++;
            sharkCount=0;
        }
        count += tmp[2];
    }
}