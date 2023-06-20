import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.isEmpty()) {
                s.add(i);
                continue;
            }
            while (!s.isEmpty()) {
                if (arr[s.peek()] < arr[i]) {
                    arr[s.peek()] = arr[i];
                    s.pop();
                } else {
                    break;
                }
            }
            s.add(i);
        }
        while (!s.isEmpty()) {
            arr[s.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }


}