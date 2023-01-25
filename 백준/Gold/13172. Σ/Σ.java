import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    private static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        long sum = 0;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            sum = (sum + (b* func(MOD-2,1,a)%MOD)) % MOD ;
        }
        System.out.println(sum);
    }

    private static long func(int mul, long current, long a) {
        if (mul==1){
            return a;
        }
        current = current * func(mul / 2, current, a) % MOD;
        if (mul%2==0){
            return current *current % MOD;
        }
        return (((current*current) % MOD) *a) % MOD;
    }
}

