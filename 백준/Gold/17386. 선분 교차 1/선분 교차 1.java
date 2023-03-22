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

        if (tmp1 <= 0 && tmp2 <= 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

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