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
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> (int)o[1]));
        q.add(new long[]{a, 0});
        while (!q.isEmpty()) {
            long[] tmp = q.poll();
            if (tmp[0] > b) {
                continue;
            } else if (tmp[0] == b) {
                System.out.println(tmp[1] + 1);
                return;
            }
            if (tmp[0] * 2 <= 1_000_000_000) {
                q.add(new long[]{tmp[0] * 2, tmp[1] + 1});
            }
            long addOne = tmp[0] * 10 + 1;
            if (addOne <= 1_000_000_000) {
                q.add(new long[]{addOne, tmp[1] + 1});
            }
        }
        System.out.println(-1);

    }

}
