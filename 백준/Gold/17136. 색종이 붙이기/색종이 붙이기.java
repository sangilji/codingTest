import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] colorPaper = new int[6];
    static int[][] originalMap = new int[11][11];
    static int max = 25;
    static int[][] tmpMap = new int[11][11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(colorPaper, 5);
        for (int i = 1; i < 11; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 11; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        dfs(0, 1, 1);
        if (max == 25) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }

    }


    private static void dfs(int count, int x, int y) {

        if (x >= 10 && y > 10) {
            if (checkMap(tmpMap)) {
                max = Math.min(count, max);
            }
            return;
        }
        if (y > 10) {
            dfs(count, x + 1, 1);
            return;
        }
        if (count >= max) {
            return;
        }

        if (originalMap[x][y] == 1 && tmpMap[x][y] !=1) {

            for (int k = 5; k > 0; k--) {
                if (colorPaper[k] > 0 && checkPut(x, y, k)) {
                    make(x, y, k, 1);
                    colorPaper[k]--;
                    dfs(count + 1, x, y + 1);
                    make(x, y, k, 0);
                    colorPaper[k]++;
                }
            }
        } else {
            dfs(count,x,y+1);
        }
    }

    private static boolean checkMap(int[][] map) {

        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                if (originalMap[i][j] != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void make(int x, int y, int size, int k) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                tmpMap[i][j] = k;
            }
        }
    }

    private static boolean checkPut(int x, int y, int size) {
        if (x + size > 11 || y + size > 11) {
            return false;
        }
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (originalMap[i][j] != 1 || tmpMap[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}