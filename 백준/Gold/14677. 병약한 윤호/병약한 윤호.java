import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] meds;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        meds = new int[3 * N];
        String seq = bf.readLine();
        for (int i = 0; i < 3 * N; i++) {
            if (seq.charAt(i) == 'B') {
                meds[i] = 0;
            } else if (seq.charAt(i) == 'L') {
                meds[i] = 1;
            } else {
                meds[i] = 2;
            }
        }
        dp = new int[3][3 * N + 1][3 * N + 1];
        reset();
        System.out.println(topDown(0, 0, 3 * N - 1));
    }

    public static int topDown(int cnt, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (dp[cnt][start][end] != -1) {
            return dp[cnt][start][end];
        }
        int temp = 0;
        if (meds[start] == cnt) {
            temp = topDown((cnt + 1) % 3, start + 1, end) + 1;
        }
        if (meds[end] == cnt) {
            temp = Math.max(temp,topDown((cnt + 1) % 3, start, end - 1) + 1);
        }
        dp[cnt][start][end] = Math.max(dp[cnt][start][end], temp);
        return dp[cnt][start][end];
    }

    public static void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= 3 * N; j++) {
                for (int k = 0; k <= 3 * N; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
    }
}