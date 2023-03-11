import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int w;
    static int h;
    static int result;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            result = 12 * 15;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            int[][] map = new int[h][w];
            for (int j = h - 1; j >= 0; j--) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < w; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0, map);
            sb.append("#").append(i).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int depth, int[][] map) {
        if (depth == n) {
            checkMin(map);
            if (result == 180) {
                for (int i = h-1; i >= 0; i--) {
                    System.out.println(Arrays.toString(map[i]));
                }
                System.out.println();
            }
            return;
        }
        for (int i = 0; i < w; i++) {
            int j = findTop(i, map);

            if (j >= 0) {
                int[][] tmpMap = new int[h][];
                for (int k = 0; k < h; k++) {
                    tmpMap[k] = map[k].clone();
                }
                breakMap(j, i, tmpMap);
                getOffMap(tmpMap);
                dfs(depth + 1, tmpMap);
            } else{
                dfs(depth + 1, map);
            }
        }
    }

    private static void getOffMap(int[][] map) {
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (map[j][i] > 0) {
                    int tmpJ = findBlank(i, map);
                    if (tmpJ==-1){
                        break;
                    }
                    if (j<tmpJ){
                        continue;
                    }

                    map[tmpJ][i] = map[j][i];
                    map[j][i] = 0;
                }
            }
        }
    }

    private static void breakMap(int x, int y, int[][] map) {
        int depth = map[x][y];
        map[x][y] = 0;
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < 4; j++) {
                int tx = x + dx[j] * i;
                int ty = y + dy[j] * i;
                if (tx < 0 || ty < 0 || tx >= h || ty >= w) {
                    continue;
                }
                if (map[tx][ty] > 1) {
                    breakMap(tx, ty, map);
                }
                map[tx][ty] = 0;
            }
        }
    }

    private static int findTop(int i, int[][] map) {
        for (int j = h - 1; j >= 0; j--) {
            if (map[j][i] > 0) {
                return j;
            }
        }
        return -1;
    }

    private static int findBlank(int i, int[][] map) {
        for (int j = 0; j < h; j++) {
            if (map[j][i] == 0) {
                return j;
            }
        }
        return -1;
    }

    private static void checkMin(int[][] map) {
        int min = 0;
        for (int i = 0; i < h; i++) {
            int count = 0;
            for (int j = 0; j < w; j++) {
                if (map[i][j] > 0) {
                    count++;
                }
            }
            if (count == 0) {
                break;
            }
            min += count;
        }
        result = Math.min(min, result);
    }
}
