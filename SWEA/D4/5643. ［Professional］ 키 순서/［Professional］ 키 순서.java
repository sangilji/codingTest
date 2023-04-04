import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int n;
    static int m;
    static int[][] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());
            nodes = new int[n + 1][n + 1];
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if (j==k){
                        continue;
                    }
                    nodes[j][k] = 10000;
                }
            }
            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                nodes[a][b] = 1;
            }
            int result = 0;
            for (int j = 1; j < n+1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if (j == k) {
                        continue;
                    }
                    for (int l = 1; l < n+1; l++) {
                        if (l == j || k == l) {
                            continue;
                        }
                        nodes[k][l] = Math.min(nodes[k][j] + nodes[j][l], nodes[k][l]);
                    }
                }
            }

            for (int j = 1; j < n+1; j++) {
                int count = n;
                for (int k = 1; k < n+1; k++) {
                    if (j == k) {
                        continue;
                    }
                    if (nodes[j][k] == 10000 && nodes[k][j] == 10000) {
                        count--;
                    }
                }
                if (count == n) {
                    result++;
                }
//                System.out.println(count);
            }
            sb.append("#")
                    .append(i)
                    .append(" ")
                    .append(result)
                    .append("\n");
        }
        System.out.println(sb);
    }
}