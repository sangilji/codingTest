import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    private static final int[] dx = {0,1,0,-1};
    private static final int[] dy = {1,0,-1,0};
    static int[][] map;
    static int n;

    static int max;
    static int startMin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            n = Integer.parseInt(br.readLine());
            max = 0;
            map = new int[n][n];
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int tmp = bfs(j,k);
                    if (max<tmp){
                        max = tmp;
                        startMin = map[j][k];
                    } else if (max == tmp) {
                        startMin =Math.min(startMin,map[j][k]);
                    }
                }
            }
           sb.append("#").append(i).append(" ").append(startMin).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        int point = 0;
        q.add(new int[]{x,y});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            point++;
            for (int i = 0; i < 4; i++) {
                int tx = dx[i] +tmp[0];
                int ty = dy[i] +tmp[1];
                if (tx<0||ty<0||tx>=n||ty>=n|| map[tmp[0]][tmp[1]] +1 != map[tx][ty]){
                    continue;
                }
                q.add(new int[]{tx,ty});
            }
        }

        return point;
    }


}