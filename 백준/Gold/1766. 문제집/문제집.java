import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] count = new int[n + 1];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        List<Integer> arr[] = new ArrayList[n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            count[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int tmp = q.poll();

            sb.append(tmp).append(" ");
            for (int i = 0; i < arr[tmp].size(); i++) {
                int num = arr[tmp].get(i);
                count[num]--;
                if (count[num] == 0) {
                    q.add(num);
                }
            }
        }
        System.out.println(sb);
    }
}

