import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int MOD = 1000000000;
    static int n;
    static int r;
    static int m;

    static int[][] arr;


    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(tmp[j - 1]);
            }
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] != 0) {
                    arr[i][j] = Math.min(arr[i - 1][j - 1], Math.min(arr[i - 1][j], arr[i][j - 1])) + 1;
                }
            }
        }

        long max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                max = Math.max(arr[i][j], max);
            }
        }
        System.out.println(max * max);


    }


}