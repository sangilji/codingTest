import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ramen = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            ramen[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n + 1; i++) {
            if (i < n - 1) {
                if (ramen[i + 1] > ramen[i + 2]) {
                    int a = ramen[i + 1] - ramen[i + 2];
                    int tmp = Math.min(ramen[i], a);
                    result += tmp * 5;
                    ramen[i] -= tmp;
                    ramen[i + 1] -= tmp;
                }
                int tmp = Math.min(ramen[i], Math.min(ramen[i + 1], ramen[i + 2]));
                result += tmp * 7;
                ramen[i] -= tmp;
                ramen[i + 1] -= tmp;
                ramen[i + 2] -= tmp;
            }

            if (i < n) {
                int tmp = Math.min(ramen[i], ramen[i + 1]);
                result += tmp * 5;
                ramen[i] -= tmp;
                ramen[i + 1] -= tmp;
            }

            result += ramen[i] * 3;
        }
        System.out.println(result);

    }


}
// 0 1 0 1