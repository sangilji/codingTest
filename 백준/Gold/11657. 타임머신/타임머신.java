import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static List<int[]> nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nodes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes.add(new int[]{a, b, c});
        }

        ford();

    }

    private static void ford() {
        int INF = 987654321;
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < m; j++) {
                int[] tmp = nodes.get(j);

                if (dist[tmp[0]] != INF && dist[tmp[1]] > dist[tmp[0]] + tmp[2]) {
                    dist[tmp[1]] = dist[tmp[0]] + tmp[2];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int[] tmp = nodes.get(i);

            if (dist[tmp[0]] != INF && dist[tmp[1]] > dist[tmp[0]] + tmp[2]) {
                System.out.println(-1);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < n + 1; i++) {
            if (dist[i] == INF) {
                sb.append("-1\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}