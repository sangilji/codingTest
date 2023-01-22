import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        q.add(new int[]{n, 0});

        boolean[] visit = new boolean[100001];

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            if (visit[tmp[0]]) {
                continue;
            }
            visit[tmp[0]] = true;
            if (tmp[0] == k) {
                System.out.println(tmp[1]);
                break;
            }
            if (tmp[0] - 1 >= 0) {
                q.add(new int[]{tmp[0] - 1, tmp[1] + 1});
            }
            if (tmp[0] * 2 <= 100000) {
                q.add(new int[]{tmp[0] * 2, tmp[1]});
            }
            if (tmp[0] + 1 <= 100000) {
                q.add(new int[]{tmp[0] + 1, tmp[1] + 1});
            }
        }
    }

}
