import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long r = Long.parseLong(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        long[] fac = new long[p];
        fac[0] = 1;

        // 팩토리얼 구하기
        for (int i = 1; i < p; i++) {
            if (i % MAX == 0) {
                for (int j = i / MAX; j > 0; j--) {
                    fac[i] = (fac[i] * pow(fac[MAX - 1], p - 2, p)) % p;
                }
            }
            fac[i] = (fac[i - 1] * i) % p;
        }

        long res = 1;
        while (n > 0 || r > 0) {
            long nModP = n % p;
            long rModP = r % p;
            n /= p;
            r /= p;

            if (nModP < rModP) {
                res = 0;
                break;
            }

            long tmp = (fac[(int) nModP] * pow((fac[(int) rModP] * fac[(int) (nModP - rModP)]) % p, p - 2, p)) % p;
            res = (res * tmp) % p;
        }

        System.out.println(res);

    }

    static long pow(long base, long exponent, int mod) {
        long res = 1;
        base %= mod;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                res = (res * base) % mod;
            }

            exponent /= 2;
            base = (base * base) % mod;
        }

        return res;
    }
}