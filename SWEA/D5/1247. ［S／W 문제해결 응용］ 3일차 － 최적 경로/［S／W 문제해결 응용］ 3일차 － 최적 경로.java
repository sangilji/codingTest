import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static boolean[] visit;
    static int[][] clients;
    static int companyX;
    static int companyY;
    static int houseX;
    static int houseY;
    static int min;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; i++) {
            min = Integer.MAX_VALUE;
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            companyX = Integer.parseInt(st.nextToken());
            companyY = Integer.parseInt(st.nextToken());
            houseX = Integer.parseInt(st.nextToken());
            houseY = Integer.parseInt(st.nextToken());
            clients = new int[n][2];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    clients[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            visit = new boolean[n];
            dfs(0, companyX, companyY, 0);

            sb.append("#")
                    .append(i)
                    .append(" ")
                    .append(min)
                    .append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int depth, int x, int y, int distance) {
        if (depth == n) {
            min = Math.min(min,distance+calDistance(x,y,houseX,houseY));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            dfs(depth + 1, clients[i][0], clients[i][1], distance + calDistance(x, y, clients[i][0], clients[i][1]));
            visit[i] = false;
        }
    }


    private static int calDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}