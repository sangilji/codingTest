import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int T;
    static int N;
    static int map[][] = new int[2001][2001];
    static final int stand = 1000;
    static int res[] = new int[6];

    public static void main(String[] args) {
        // Init
        Init();

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            sb.append(ans[sc.nextInt()]).append('\n');
        }
        System.out.println(sb.toString());

    }

    static int dy[] = { -1, 1, 2, 1, -1, -2 };
    static int dx[] = { -1, -1, 0, 1, 1, 0 };

    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            super();
            this.y = y;
            this.x = x;
        }
    }

    static int[] ans = new int[10001];
    static boolean check[] = new boolean[6];

    public static void Init() {

        res[1] = 1;
        res[2] = 1;
        int y = stand;
        int x = stand;
        int d = 5;
        map[y][x] = 1;
        y = y - 1;
        x = x + 1;
        map[y][x] = 2;
        ans[1] = 1;
        ans[2] = 2;

        for (int i = 2; i < 10000; i++) {
            // 일단 놔둘 위치찾기.
            int nd = (d + 1) % 6;
            int ny = y + dy[nd];
            int nx = x + dx[nd];
//			System.out.println(d);
//			System.out.println(nd);
//			System.out.println((y-stand) +" "+(x-stand));
            if (map[ny][nx] != 0) {
                ny = y + dy[d];
                nx = x + dx[d];
                nd = d;
            }

            // 다음에 놔둘위치가 ny nx 인게 정해젔다
            y = ny;
            x = nx;
            d = nd;
            // y , x에 인접한 녀석들을 찾아낸다.
            Arrays.fill(check, false);
            for (int dir = 0; dir < 6; dir++) {
                ny = y + dy[dir];
                nx = x + dx[dir];
                check[map[ny][nx]] = true;
            }
            int c = 1;
            for (c = 1; c <= 5; c++) {
                if (!check[c])
                    break;
            }

            int minValue = res[c];

            for (int r = c + 1; r <= 5; r++) {
                if (minValue > res[r]&&!check[r]) {
                    minValue = res[r];
                    c = r;
                }
            }
            // 자원을 찾음 c
            map[y][x] = c;
            ans[i + 1] = c;
            res[c]++;
        }
    }
}