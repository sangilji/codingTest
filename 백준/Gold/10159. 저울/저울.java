import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] nodes = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(nodes[i], 3000);
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a][b] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if (i == j) {
                        nodes[i][j] = 1;
                        continue;
                    }
                    if (nodes[j][k] > nodes[j][i] + nodes[i][k]) {
                        nodes[j][k] = 1;
                    }
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            int count = 0;
            for (int j = 1; j < n + 1; j++) {
                if (nodes[i][j] == 3000 && nodes[j][i] == 3000) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }


}