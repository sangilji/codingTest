import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][][] dp;
    static List<Integer> list = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list.add(0);
        while (true) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp == 0) {
                break;
            }
            list.add(tmp);
        }
        n = list.size();
        dp = new int[n][5][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][j][k] = 987654321;
                }
            }
        }
        dp[0][0][0] = 0;
        for (int i = 0; i < n - 1; i++) {
            int next = list.get(i + 1);
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    int current = dp[i][j][k];
                    if (next != k) {
                        dp[i + 1][next][k] = Math.min(dp[i + 1][next][k], current + solve(j, next));
                    }

                    if (next != j) {
                        dp[i + 1][j][next] = Math.min(dp[i + 1][j][next], current + solve(k, next));
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                result = Math.min(result, dp[n - 1][i][j]);
            }
        }
        System.out.println(result);

    }

    private static int solve(int j, int next) {
        int a = Math.abs(j - next);
        if (j == 0) {
            return 2;
        } else if (a == 0) {
            return 1;
        } else if (a == 2) {
            return 4;
        } else {
            return 3;
        }
    }


}