import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int d;
    static List<Enemy> enemies;

    static class Enemy {
        int x;
        int y;

        public Enemy(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move() {
            x++;
        }

        public boolean checkDie() {
            if (x >= n) {
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return "Enemy{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static class Bow {
        int x;
        int y;
        Enemy enemy = null;
        int enemyDistance;

        public Bow(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void kill(Enemy enemy) {
            int tmp = calDistance(x, enemy.x, y, enemy.y);
//            System.out.println("tmp = " + tmp);
//            System.out.println(enemyDistance);
            if (tmp <= d) {
                if (this.enemy == null) {
                    this.enemy = enemy;
                    this.enemyDistance = tmp;
                } else {
                    if (enemyDistance > tmp) {
                        this.enemy = enemy;
                        this.enemyDistance = tmp;
                    } else if (enemyDistance == tmp && this.enemy.y > enemy.y) {
                        this.enemy = enemy;
                    }
                }

            }
        }

        public Enemy getEnemy() {
            Enemy tmp = this.enemy;
            this.enemy = null;
            return tmp;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        enemies = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    enemies.add(new Enemy(i, j));
                }
            }
        }

        makeBows(0, 0);
        System.out.println(max);
    }

    static int[] arr = new int[3];
    static int max = 0;

    private static void makeBows(int depth, int start) {
        if (depth == 3) {
//            System.out.println(Arrays.toString(arr));
            List<Bow> bows = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                bows.add(new Bow(n, arr[i]));
            }
            max = Math.max(max, run(bows));
            return;
        }

        for (int i = start; i < m; i++) {
            arr[depth] = i;
            makeBows(depth + 1, i + 1);
        }
    }

    private static int run(List<Bow> bows) {
        int count = 0;
        List<Enemy> tmpEnemies = new ArrayList<>();

        for (Enemy e : enemies){
            tmpEnemies.add(new Enemy(e.x, e.y));
        }
        for (int i = 0; i < n; i++) {
//            System.out.println("i = " + i);
            for (Enemy e : tmpEnemies) {
                for (Bow b : bows) {
                    if (!e.checkDie()) {
                        b.kill(e);
                    }
                }

            }
            Set<Enemy> enemySet = new HashSet<>();
            for (Bow b : bows) {
//                    System.out.println("b.x = " + b.x);
                if(b.enemy !=null) {
                    enemySet.add(b.getEnemy());
                }
            }
            count += enemySet.size();
            tmpEnemies.removeAll(enemySet);
            List<Enemy> deleteList = new ArrayList<>();
            for (Enemy e : tmpEnemies) {
                e.move();
                if (e.checkDie()) {
                    deleteList.add(e);
                }
            }
            tmpEnemies.removeAll(deleteList);
        }
//        System.out.println(count);
        return count;
    }

    public static int calDistance(int x1, int x2, int y1, int y2) {
//        System.out.println(x1+","+y1+":"+x2+","+y2);
//        System.out.println(Math.abs(x1 - x2) + Math.abs(y1 - y2));
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}