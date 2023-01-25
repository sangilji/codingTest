import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Long> s = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        long count = 0;
        for (int i = 0; i < n; i++) {
            long building = Long.parseLong(br.readLine());
            while (!s.isEmpty()) {
                if (s.peek()>building) {
                    break;
                }
                s.pop();
            }
            count += s.size();
            s.push(building);
        }
        System.out.println(count);
    }

}

