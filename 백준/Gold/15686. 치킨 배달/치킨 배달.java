import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] selectedChickens;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int n;
    static int m;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selectedChickens = new int[m][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    houses.add(new int[]{i, j});
                } else if (tmp == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        dfs(0, 0);
        System.out.println(result);
    }

    private static void dfs(int depth, int start) {
        if (m == depth) {
            cal();
            return;
        }
        for (int i = start; i < chickens.size(); i++) {
            selectedChickens[depth] = chickens.get(i);
            dfs(depth + 1, i + 1);
        }
    }

    private static void cal() {
        int sum = 0;
        for (int i = 0; i < houses.size(); i++) {
            int tmp = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                tmp = Math.min(tmp, Math.abs(selectedChickens[j][0] - houses.get(i)[0]) + Math.abs(selectedChickens[j][1] - houses.get(i)[1]));
            }
            sum += tmp;
        }

        result = Math.min(sum, result);
    }
}