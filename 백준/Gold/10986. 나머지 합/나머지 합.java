import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] remain = new long[m];
        long[] sum = new long[n + 1];
        long result = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
            int tmp = (int) (sum[i] % m);
            remain[tmp]++;
            if (tmp == 0) {
                result += remain[tmp];
            } else {
                result += (remain[tmp] - 1);
            }
        }
        System.out.println(result);

    }
}