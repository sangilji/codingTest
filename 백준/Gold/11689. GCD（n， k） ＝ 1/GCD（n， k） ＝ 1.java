import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long op = n;
        for(int i = 2; i <=Math.sqrt(n)+1;i++){
            if (n % i == 0) {
                while (n % i == 0) {
                    n/=i;
                }
                op-=op/i;
            }
        }
        if (n > 1) {
            op -= op / n;
        }
        System.out.println(op);
    }


}