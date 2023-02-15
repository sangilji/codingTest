import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)){
                return o1-o2;
            }
            return Math.abs(o1) - Math.abs(o2);
        });

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp ==0){
                if (q.isEmpty()){
                    sb.append(0).append("\n");
                    continue;
                }
                sb.append(q.poll()).append("\n");
            } else {
                    q.add(tmp);
            }
        }
        System.out.println(sb);
    }
}