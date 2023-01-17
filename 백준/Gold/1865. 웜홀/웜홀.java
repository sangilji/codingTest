
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<int[]> nodes;
    private static int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodes = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                nodes.add(new int[]{a, b, cost});
                nodes.add(new int[]{b, a, cost});
            }
            for (int j = 0; j < w; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                nodes.add(new int[]{a, b, -cost});
            }
            if (ford(n, 2 * m + w, 1)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }

        }
        System.out.println(sb);
    }

    private static boolean ford(int n, int m, int num) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[num] = 0;
        boolean update = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int[] tmp = nodes.get(j);

                if (dist[tmp[1]] > dist[tmp[0]] + tmp[2]) {
                    dist[tmp[1]] = dist[tmp[0]] + tmp[2];
                    update = true;
                }
            }
            if (!update) {
                break;
            }

        }
        if (update) {
            for (int j = 0; j < m; j++) {
                int[] tmp = nodes.get(j);
                if (dist[tmp[1]] > dist[tmp[0]] + tmp[2]) {
                    return true;
                }
            }
        }

        return false;
    }

}
