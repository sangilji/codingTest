import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static String[][] map;
    static int n;
    static int m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Character {
        int x;
        int y;
        int moveCount;
        int[] keys;

        public Character(int x, int y, int[] keys, int moveCount) {
            this.x = x;
            this.y = y;
            this.keys = keys;
            this.moveCount = moveCount;


        }

        public boolean findKey(String door) {
            return keys[door.toLowerCase().charAt(0)-'a'] ==1;
        }

        public boolean addKey(String key) {
            if (!findKey(key)) {
                keys[key.charAt(0)-'a'] = 1;
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new String[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
        }
        bfs();

    }

    private static void bfs() {
        Queue<Character> q = new ArrayDeque<>();
        boolean[][][][][][][][] visit = new boolean[n][m][2][2][2][2][2][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j].equals("0")) {
                    Character character = new Character(i, j, new int[6], 0);
                    visit[i][j][0][0][0][0][0][0] = true;
                    q.add(character);
                    break;
                }
            }
            if (!q.isEmpty()) {
                break;
            }
        }
        while (!q.isEmpty()) {
            Character current = q.poll();
//            System.out.println(current.x+":"+ current.y);
//            System.out.println(current.keys);
            String tmp = map[current.x][current.y];
            if (tmp.equals("1")) {
                System.out.println(current.moveCount);
                return;
            }
            if (tmp.matches("[a-f]")) {
                if (current.addKey(tmp)) {
//                    q.clear();
                }
            }
            if (tmp.matches("[A-F]")) {
                if (!current.findKey(tmp)) {
                    continue;
                }
            }
            for (int i = 0; i < 4; i++) {
                int x = current.x + dx[i];
                int y = current.y + dy[i];
                if (x < 0 || y < 0 || x >= n || y >= m || map[x][y].equals("#")) {
                    continue;
                }
                if (visit[x][y][current.keys[0]][current.keys[1]][current.keys[2]][current.keys[3]][current.keys[4]][current.keys[5]]){
                    continue;
                }
                visit[x][y][current.keys[0]][current.keys[1]][current.keys[2]][current.keys[3]][current.keys[4]][current.keys[5]] = true;
                q.add(new Character(x, y, current.keys.clone(), current.moveCount + 1));
            }
        }

        System.out.println(-1);
    }


}