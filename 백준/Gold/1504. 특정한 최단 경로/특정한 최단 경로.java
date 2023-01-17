import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 200_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[][] costs = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    costs[i][j] = INF;
                }
            }
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            costs[a][b] = costs[b][a] = c;
        }
        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    costs[j][k] = Math.min(costs[j][k], costs[j][i] + costs[i][k]);
                }
            }

        }
        if ((costs[1][a] ==INF || costs[a][b]==INF || costs[b][n] ==INF) ||(costs[1][b] ==INF || costs[b][a]==INF || costs[a][n] ==INF)){
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(costs[1][a] + costs[a][b] + costs[b][n], costs[1][b] + costs[b][a] + costs[a][n]));

    }


}
