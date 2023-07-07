import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long start = 1;
        long last = Integer.MAX_VALUE;
        long mid = 0;
        while (start <= last) {
            mid = (start + last) / 2;
            long sum = 0;
            for (int i = 1; i <= n; i++) {
                long tmp = Math.min(mid, (long) i * n);
                sum += tmp / i;
            }

            if (sum < k) {
                start= mid+1;
            } else {
                last = mid -1;
            }
        }
        System.out.println(start);
    }
}