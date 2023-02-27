import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] parents;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            parents = new int[n + 1];
            for (int j = 1; j < n + 1; j++) {
                parents[j] = j;
            }
            sb.append("#").append(i).append(" ");
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int tmp = union(command, a, b);
                if (command==1){
                    sb.append(tmp);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int union(int command, int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootB == rootA) {
            return 1;
        }
        if (command==1){
            return 0;
        }
        if (rootA < rootB) {
            parents[rootB] = rootA;
        } else {
            parents[rootA] = rootB;
        }
        return 0;
    }

    private static int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }
}