import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());

        int ccw = ccw(x1, y1, x2, y2, x3, y3);
        System.out.println(ccw);
    }

    private static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        int tmp = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
        if (tmp > 0) {
            return 1;
        } else if (tmp < 0) {
            return -1;
        }
        return 0;
    }


}