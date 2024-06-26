import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
    import java.util.StringTokenizer;

    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
    // click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    public class Main {

        static int n;
        static int m;
        static int k;
        static int[][] arr;
        static int[] visit;
        static int[][][][] dp;
        static List<Integer>[] list;
        static StringBuilder sb = new StringBuilder();

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            n= Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n][4];
            dp = new int[n+1][m+1][n+1][2];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    for (int l = 0; l <= n; l++) {
                        Arrays.fill(dp[i][j][l], -1);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                st  =new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(recur(0, 0, 0, 0));
        }

        private static int recur(int depth, int a, int b, int count) {
            if (depth == n) {
                if (b < k) {
                    return -12313131;
                }
                return 0;
            }
            if (dp[depth][a][b][count] != -1) {
                return dp[depth][a][b][count];
            }
            int tmp = -321321321;
            tmp = Math.max(tmp, recur(depth + 1, a, b + 1, 0) + arr[depth][0]);
            tmp = Math.max(tmp, recur(depth + 1, a, b + 1, 0) + arr[depth][1]);
            if (count == 0) {
                tmp = Math.max(tmp, recur(depth + 1, a, b, 1) + arr[depth][2]);
            }
            if (a < m) {
                tmp = Math.max(tmp, recur(depth + 1, a+1, b, 0) + arr[depth][3]);
            }
            return dp[depth][a][b][count] = tmp;
        }


    }