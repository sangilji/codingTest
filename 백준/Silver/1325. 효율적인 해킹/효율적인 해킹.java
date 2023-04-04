import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] counts;
    static int n;
    static List<Integer>[] nodes;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        counts = new int[n + 1];
        nodes = new List[n + 1];
        visit = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[b].add(a);
        }

        for (int i = 1; i < n + 1; i++) {
            counts[i] = bfs(i) ;

        }
//        System.out.println(Arrays.toString(counts));
        int maxV = Arrays.stream(counts).max().getAsInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            if (counts[i] == maxV) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static int bfs(int current) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(current);
        boolean[] visit = new boolean[n + 1];
        int count = 0;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            if (visit[tmp]){
                continue;
            }
            visit[tmp] = true;
            count++;
            q.addAll(nodes[tmp]);
        }
        return count;
    }


}