import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static long[] dp = new long[55];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken()) - 1;
        long m = Long.parseLong(st.nextToken());

        dp[0] = 1;
        for (int i = 1; i < 55; i++) {
            dp[i] = (dp[i - 1] << 1) + (1L << i);
        }
        long a = m & 1;
        int size = (int) (Math.log(m) / Math.log(2));

        for (int i = size; i > 0; i--) {
            if ((m & (1L << i)) != 0L) {
                a += dp[i - 1] + (m - (1L << i) + 1);
                m -= (1L << i);
            }
        }

        long b = n & 1;
        size = (int) (Math.log(n) / Math.log(2));

        for (int i = size; i > 0; i--) {
            if ((n & (1L << i)) != 0L) {
                b += dp[i - 1] + (n - (1L << i) + 1);
                n -= (1L << i);
            }
        }

        System.out.println(a - b);
    }


}

/*
   1
  10 2
  11
 100 4
 101
 110
 111
1000 8
1001 9
1010 10
1011 11
1100 12
 */