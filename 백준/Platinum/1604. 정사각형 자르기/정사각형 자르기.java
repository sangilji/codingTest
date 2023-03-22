import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] pos;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        pos = new int[n][4];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                pos[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 1;
        for (int i = 0; i < n; i++) {
            int x1 = pos[i][0];
            int y1 = pos[i][1];
            int x2 = pos[i][2];
            int y2 = pos[i][3];
            double as = 0;
            if (x2 != x1) {
                as = 1.0*(y2 - y1) / (x2 - x1);
            }
            double aB = y1 - as * x1;

            if (as == 0) {
                if (x2 == x1) {
                    if (x1 >= 10 || x1 <= -10) {
                        continue;
                    }
                    if (Math.max(y1, y2) < -10 || Math.min(y1, y2) > 10) {
                        continue;
                    }
                } else if (y1 == y2) {
                    if (y1 >= 10 || y1 <= -10) {
                        continue;
                    }
                    if (Math.max(x1, x2) < -10 || Math.min(x1, x2) > 10) {
                        continue;
                    }
                }
            } else {
                boolean b = Math.max(x1, x2) < -10 || Math.min(x1, x2) > 10 || Math.max(y1, y2) < -10 || Math.min(y1, y2) > 10;

                if (as > 0) {
                    if (as * -10 + aB >= 10 || as * 10 + aB <= -10) {
                        continue;
                    }
                } else {
                    if (as * -10 + aB <= -10 || as * 10 + aB >= 10) {
                        continue;
                    }
                }
                if (b) {
                    continue;
                }
            }

            visit[i] = true;
            count++;
            for (int j = 0; j < i; j++) {
                if (!visit[j]) {
                    continue;
                }
                int x3 = pos[j][0];
                int y3 = pos[j][1];
                int x4 = pos[j][2];
                int y4 = pos[j][3];
                int tmp1 = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4);
                int tmp2 = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2);
                if ((tmp1 <= 0 && tmp2 <= 0) && check(i, j)) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    private static boolean check(int i, int j) {


        double as = 0;
        if (pos[i][2] != pos[i][0]) {
            as = 1.0*(pos[i][3] - pos[i][1]) / (pos[i][2] - pos[i][0]);
        }
        double bs = 0;
        if (pos[j][2] != pos[j][0]) {
            bs = 1.0*(pos[j][3] - pos[j][1]) / (pos[j][2] - pos[j][0]);
        }

        double aB = pos[i][1] - as * pos[i][0];
        boolean b1 = false;
        if (pos[i][0] == pos[i][2]) {
            b1 = true;
            aB = pos[i][0];
        }
        double bB = pos[j][1] - bs * pos[j][0];
        boolean b2 = false;
        if (pos[j][0] == pos[j][2]) {
            b2 = true;
            bB = pos[j][0];
        }
        //
        double x = 1.0*(aB - bB) / (bs - as);
        double y = x * as + aB;

        if (b1) {
            x = aB;
            y = aB * bs + bB;
        } else if (b2) {
            x = bB;
            y = bB * as + aB;
        }

        if (x < 10 && x > -10 && y < 10 && y > -10) {
            return true;
        }
        return false;
    }

    public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long op = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
        if (op > 0) {
            return 1;
        } else if (op == 0) {
            return 0;
        }
        return -1;
    }

}