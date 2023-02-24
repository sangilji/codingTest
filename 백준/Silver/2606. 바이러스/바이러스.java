import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] virus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer = Integer.parseInt(br.readLine());
        int network = Integer.parseInt(br.readLine());
        virus = new List[computer + 1];
        for (int i = 0; i < computer + 1; i++) {
            virus[i] = new ArrayList<>();
        }
        for (int i = 0; i < network; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            virus[a].add(b);
            virus[b].add(a);
        }

        boolean[] visit = new boolean[computer + 1];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        int count = 0;
        while (!q.isEmpty()) {
            int tmp = q.poll();

            if (visit[tmp]) {
                continue;
            }
            visit[tmp] = true;
            count++;
            for (int i = 0; i < virus[tmp].size(); i++) {
                int next = virus[tmp].get(i);
                if (!visit[next]) {

                    q.add(next);
                }
            }
        }
        System.out.println(count - 1);
    }
}