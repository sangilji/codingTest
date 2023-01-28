import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> bag;

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            q.add(new int[]{m, v});
        }
        bag = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            bag.add(Integer.parseInt(br.readLine()));
        }
        bag.sort(Integer::compareTo);

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        long result = 0;
        for (int i = 0; i < bag.size(); i++) {
            int tmp = bag.get(i);
            while (!q.isEmpty()) {
                if (q.peek()[0] <= tmp) {
                    pq.add(q.poll()[1]);
                } else {
                    break;
                }
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }
        System.out.println(result);
    }
}

