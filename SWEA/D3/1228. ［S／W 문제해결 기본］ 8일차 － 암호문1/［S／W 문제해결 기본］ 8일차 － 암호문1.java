import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<Integer> q = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                q.add(Integer.parseInt(st.nextToken()));
            }

            int commands = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < commands; j++) {
                String insert = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                Stack<Integer> tmpS = new Stack<>();
                while (x-->0){
                    tmpS.add(q.pollFirst());
                }
                int y = Integer.parseInt(st.nextToken());
                for (int k = 0; k < y; k++) {
                    tmpS.add(Integer.parseInt(st.nextToken()));
                }
                while (!tmpS.isEmpty()){
                    q.addFirst(tmpS.pop());
                }

            }
            sb.append("#").append(i+1).append(" ");
            for (int j = 0; j < 10; j++) {
                sb.append(q.pollFirst()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}