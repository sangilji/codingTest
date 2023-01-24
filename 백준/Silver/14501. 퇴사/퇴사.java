import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visit;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] consulting = new int[n + 1][2];
        int[] dp = new int[n + 1];
        StringTokenizer st;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                consulting[i][j] = Integer.parseInt(st.nextToken());
                dp[i] = consulting[i][j];
                if (consulting[i][0] - 1 + i > n) {
                    dp[i] = 0;
                    break;
                }
            }
        }


        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (consulting[j][0] + j <= i) {
                    dp[i] = Math.max(consulting[i][1] + dp[j], dp[i]);
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

}

