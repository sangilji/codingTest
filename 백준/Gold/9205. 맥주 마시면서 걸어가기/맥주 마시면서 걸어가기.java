import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int[][] store;
    static int n;
    static boolean[] visit;
    static List<int[]>[] nodes;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            nodes = new List[n + 2];
            for (int j = 0; j < n + 2; j++) {
                nodes[j] = new ArrayList<>();
            }
            store = new int[n + 2][2];
            for (int j = 0; j < n + 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 2; k++) {
                    store[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < n + 2; j++) {
                for (int k = j + 1; k < n + 2; k++) {
                    int d = dis(store[j], store[k]) <=1000?1:1000;
                    nodes[j].add(new int[]{k, d});
                    nodes[k].add(new int[]{j, d});
                }
            }

            if(go()){
                sb.append("happy\n");
            } else {
                sb.append("sad\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean go() {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[] dist = new int[n + 2];
        visit = new boolean[n + 2];
        Arrays.fill(dist, 987654321);
        dist[0] = 0;
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (visit[tmp[0]]) {
                continue;
            }
            visit[tmp[0]] = true;
            for (int[] next : nodes[tmp[0]]) {
                if (tmp[1] + next[1] < dist[next[0]]) {
                    dist[next[0]] = tmp[1] + next[1];
                    q.add(new int[]{next[0],dist[next[0]]});
                }
            }
        }
        if (dist[n + 1] < 1000) {
            return true;
        }
        return false;

    }

    private static int dis(int[] current, int[] dest) {
        return Math.abs(current[0] - dest[0]) + Math.abs(current[1] - dest[1]);
    }
}