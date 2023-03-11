import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {
    static int n;
    static int m;
    static int c;
    static int[][] map;
    static int[][] selectHoney;
    static boolean[][] visit;
    static int max;
    
    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            max = 0;
            map = new int[n][n];
            visit = new boolean[n][n];
            selectHoney = new int[2][m];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0, 0, 0);
            sb.append("#").append(i).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int depth, int x, int y) {

        if (depth == 2) {
            check();
            return;
        }
        if (x == n) {
            return;
        }
        if (y > n - m) {
            dfs(depth, x + 1, 0);
            return;
        }
        if (!visit[x][y]) {
            for (int k = 0; k < m; k++) {
                visit[x][y + k] = true;
                selectHoney[depth][k] = map[x][y + k];
            }

            dfs(depth + 1, x, y + m);

            for (int k = 0; k < m; k++) {
                visit[x][y + k] = false;
                selectHoney[depth][k] = map[x][y + k];
            }
        }
        dfs(depth, x, y + 1);

    }

    static int sumA;
    static int sumB;
    static int[] selectSum;

    private static void check() {
        selectSum = new int[m];
        sumA = Arrays.stream(selectHoney[0]).sum();
        sumB = Arrays.stream(selectHoney[1]).sum();
        int result = 0;
        if (sumA > c) {
            findMax(0, 0, 0);
            result += sumA;
        } else {
            for (int i = 0; i < m; i++) {
                result += selectHoney[0][i] * selectHoney[0][i];
            }
        }
        if (sumB > c) {
            sumA = 0;
            findMax(0, 0, 1);
            result += sumA;
        } else {
            for (int i = 0; i < m; i++) {
                result += selectHoney[1][i] * selectHoney[1][i];
            }
        }
        max = Math.max(result, max);
    }

    private static void findMax(int depth, int sum, int person) {
        if (sum > c) {
            return;
        }
        if (depth == m) {
            int tmp = 0;
            for (int i = 0; i < m; i++) {
                tmp += selectSum[i] * selectSum[i];
            }
            sumA = Math.max(tmp, sumA);
            return;
        }
        if (person == 0) {
            selectSum[depth] = selectHoney[0][depth];
            findMax(depth + 1, sum + selectHoney[0][depth], person);
        } else {

            selectSum[depth] = selectHoney[1][depth];
            findMax(depth + 1, sum + selectHoney[1][depth], person);
        }
        selectSum[depth] = 0;
        findMax(depth + 1, sum, person);
    }

}
