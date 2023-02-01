import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Long> num = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num.add(Long.parseLong(st.nextToken()));
        }
        long min = Long.MAX_VALUE;
        long a = 0;
        long b = 0;
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            long tmp = num.get(i);

            while (left <= right) {
                int mid = (left + right) / 2;

                if (num.get(mid) + tmp < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                if (Math.abs(num.get(mid) + tmp) < min) {
                    min = Math.abs(num.get(mid) + tmp);
                    a = tmp;
                    b = num.get(mid);
                }
            }
        }
        System.out.println(a + ": " + b);


    }


}
