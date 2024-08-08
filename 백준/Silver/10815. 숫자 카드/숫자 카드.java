import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a; i++) {
            int num1 = Integer.parseInt(st.nextToken());
            map.put(num1, i);
        }

        int b = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            int num2 = Integer.parseInt(st.nextToken());
            if (map.containsKey(num2)) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }


        }
    }
}