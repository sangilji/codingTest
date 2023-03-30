import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Integer> d = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[n + 1];
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n + 1; i++) {
            int tmp = arr[i];
            while (!d.isEmpty()) {
                if (arr[d.getLast()] <= tmp) {
                    break;
                }
                d.removeLast();
            }

            d.addLast(i);
            if(i-d.peek()==l){
                d.pop();
            }
            sb.append(arr[d.peek()]).append(" ");
        }
        System.out.println(sb);

    }


}

