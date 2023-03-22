import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] lines = new int[2][4];
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                lines[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x1 = lines[0][0];
        int y1 = lines[0][1];
        int x2 = lines[0][2];
        int y2 = lines[0][3];
        int x3 = lines[1][0];
        int y3 = lines[1][1];
        int x4 = lines[1][2];
        int y4 = lines[1][3];
        int tmp1 = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4);
        int tmp2 = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2);
        double as = 0;
        if (x1 != x2) {
            as = 1.0 * (y2 - y1) / (x2 - x1);
        }
        double bs = 0;
        if (x3 != x4) {
            bs = 1.0 * (y4 - y3) / (x4 - x3);
        }
        if (tmp1 <= 0 && tmp2 <= 0 && check(lines[0], lines[1])) {
            System.out.println(1);
            if (ccw(x1, y1, x2, y2, x3, y3) == 0 && ccw(x1, y1, x2, y2, x4, y4) == 0 &&
                    ccw(x3, y3, x4, y4, x1, y1) == 0 && ccw(x3, y3, x4, y4, x2, y2) == 0) {
                check2(lines[1],lines[0]);
                if (sb.length()!=0){
                    System.out.println(sb);
                }
                return;
            }


            double aB = y1 - as * x1;
            boolean b1 = false;
            if (x1 == x2) {
                b1 = true;
                aB = x1;
            }

            double bB = y3 - bs * x3;
            boolean b2 = false;
            if (x3 == x4) {
                b2 = true;
                bB = x3;
            }
            double x = (aB - bB) / (bs - as);
            double y = x * as + aB;
            if (b1) {
                x = aB;
                y = aB * bs + bB;
            } else if (b2) {
                x = bB;
                y = bB * as + aB;
            }

            System.out.println(x + " " + y);
        } else {
            System.out.println(0);
        }
        System.out.println(sb);

    }

    private static boolean check2(int[] line, int[] line1) {
        int a;
        int b;
        int c;
        int d;

        if (line[0] == line[2]) {
            a = Math.max(line[1], line[3]);
            b = Math.min(line[1], line[3]);
            c = Math.max(line1[1], line1[3]);
            d = Math.min(line1[1], line1[3]);

        } else {
            a = Math.max(line[0], line[2]);
            b = Math.min(line[0], line[2]);
            c = Math.max(line1[0], line1[2]);
            d = Math.min(line1[0], line1[2]);

        }
        if (a < c) {
            if (a > d) {
                return true;
            } else if (a == d) {
                match(line, line1);
                return true;
            } else {
                return false;
            }
        } else if (a == c) {
            return true;
        } else {
            if (b < c) {
                return true;
            } else if (b == c) {
                match(line, line1);
                return true;
            } else {
                return false;
            }
        }
    }

    private static boolean check(int[] line, int[] line1) {
        int a;
        int b;
        int c;
        int d;

        if (line[0] == line[2]) {
            a = Math.max(line[1], line[3]);
            b = Math.min(line[1], line[3]);
            c = Math.max(line1[1], line1[3]);
            d = Math.min(line1[1], line1[3]);

        } else {
            a = Math.max(line[0], line[2]);
            b = Math.min(line[0], line[2]);
            c = Math.max(line1[0], line1[2]);
            d = Math.min(line1[0], line1[2]);
        }
        if (a < c) {
            if (a >= d) {
                return true;
            } else {
                return false;
            }
        } else if (a == c) {
            return true;
        } else {
            if (b <= c) {
                return true;
            } else {
                return false;
            }
        }
    }

    private static boolean match(int[] line, int[] line1) {
        if ((line[0] == line1[0] && line[1] == line1[1])) {
            sb.append(line[0] + " " + line[1]);
            return true;
        } else if (line[0] == line1[2] && line[1] == line1[3]) {
            sb.append(line[0] + " " + line[1]);
            return true;
        } else if (line[2] == line1[0] && line[3] == line1[1]) {
            sb.append(line[2] + " " + line[3]);
            return true;
        } else if ((line[2] == line1[2] && line[3] == line1[3])) {
            sb.append(line[2] + " " + line[3]);
            return true;
        }
        return false;
    }


    public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long op = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
        if (op > 0) {
            return 1;
        }
        if (op == 0) {
            return 0;
        }
        return -1;
    }

}