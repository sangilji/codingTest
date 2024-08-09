import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a; i++) {
            int num1 = Integer.parseInt(st.nextToken()); // 토큰으로 값을 받고,
            map.put(num1, i); // map에 추가한다.
        }

        int b = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()); // 이미 사용중, 다시 선언하여 초기화
        for (int i = 0; i < b; i++) {
            int num2 = Integer.parseInt(st.nextToken());
            if (map.containsKey(num2)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}