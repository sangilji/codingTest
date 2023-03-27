import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(0);
            return;
        }
        getPrime(n);
        int count = 0;
        int start = 0;
        int end = 0;
        int sum = primes.get(0);
        while (start < primes.size() && end < primes.size()) {
            if (sum == n) {
                count++;
                sum -= primes.get(start);
                start++;
            } else if (sum > n) {
                sum -= primes.get(start);
                start++;
            } else {
                end++;
                if (end >= primes.size()) {
                    break;
                }
                sum += primes.get(end);
            }
        }
        System.out.println(count);
    }

    static void getPrime(int n) {
        int temp[] = new int[n+1];
        int rootN = (int)Math.sqrt(n);
        for(int i=2; i<=n; i++) {
            temp[i] = i;
        }
        for(int i=2; i<=rootN; i++) {
            if(temp[i] != 0 ) {
                for(int j=i+i; j<=n; j+=i) {
                    temp[j] = 0;
                }
            }
        }
        for(int i=2; i<=n; i++) {
            if(temp[i] != 0) {
                //System.out.println(temp[i]); 디버깅용
                primes.add(temp[i]);
            }
        }
    }


}