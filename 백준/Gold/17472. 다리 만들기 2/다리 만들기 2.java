import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static List<int[]>[] island = new List[7];
    static List<int[]> nodes = new ArrayList<>();
    static boolean[][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < 7; i++) {
            island[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int number = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    makeIsland(number++, i, j);
                }
            }
        }

        parent = new int[7];
        for (int i = 1; i < 6; i++) {

            if (island[i + 1].size() == 0) {
                parent = new int[i+1];
                break;
            }
            for (int j = i + 1; j < 7; j++) {
                makeNodes(i, j);
            }
        }

        nodes.sort(Comparator.comparingInt(o -> o[2]));

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int result = 0;
        for (int i = 0; i < nodes.size(); i++) {
            int parentA = find(nodes.get(i)[0]);
            int parentB = find(nodes.get(i)[1]);
            if (parentB!=parentA){
                if (parentB<parentA){
                    parent[parentA] = parentB;
                }else{
                    parent[parentB] = parentA;
                }
                result += nodes.get(i)[2];
            }
        }
        for (int i = parent.length-1; i >0; i--) {
            find(i);
        }
        int tmp = parent[1];
        for (int i = 2; i < parent.length; i++) {
            if (parent[i] != tmp){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(result);
    }

    private static int find(int i) {
        if (parent[i] == i){
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    private static void makeNodes(int x, int y) {
        int length = 101;
        for (int[] a : island[x]) {
            for (int[] b : island[y]) {
                int tmp = 0;
                if (a[0] == b[0]) {
                    tmp = check(0, a[0], a[1], b[1]);
                }
                if (a[1] == b[1]) {
                    tmp = check(1, a[1], a[0], b[0]);

                }
                if (tmp > 1) {
                    length = Math.min(length, tmp);
                }
            }

        }
        if (length != 101) {
            nodes.add(new int[]{x, y, length});
        }
    }

    private static int check(int num, int i, int a, int b) {
        int tmp = 0;
        if (a < b) {
            for (int j = a + 1; j < b; j++) {
                if (num == 0) {
                    if (map[i][j] == 1) {
                        return 0;
                    }
                } else {
                    if (map[j][i] == 1) {
                        return 0;
                    }
                }
                tmp++;
            }
        } else {
            for (int j = b + 1; j < a; j++) {
                if (num == 0) {
                    if (map[i][j] == 1) {
                        return 0;
                    }
                } else {
                    if (map[j][i] == 1) {
                        return 0;
                    }

                }
                tmp++;
            }
        }
        return tmp;
    }

    private static void makeIsland(int number, int x, int y) {
        visit[x][y] = true;
        if (number<=6)
        island[number].add(new int[]{x, y});

        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (tx < 0 || ty < 0 || tx >= n || ty >= m || visit[tx][ty]) {
                continue;
            }
            if (map[tx][ty] == 1) {
                makeIsland(number, tx, ty);
            }
        }
    }

}