import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] pos = new long[n+1][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                pos[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pos[n][0] = pos[0][0];
        pos[n][1] = pos[0][1];
        long a = 0;
        long b = 0;
        for (int i = 0; i < n; i++) {
            a+= pos[i][0]*pos[i+1][1];
            b+= pos[i][1]*pos[i+1][0];
        }
        System.out.printf("%.1f", (Math.abs(a-b)/2.0));

    }

}
