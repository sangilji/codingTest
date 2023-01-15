package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Main2407 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        BigInteger result = new BigInteger(String.valueOf(1));
        int a = 1;
        for (int i = n; m > 0; i--, m--) {
            result = result.multiply(BigInteger.valueOf(i));
            result = result.divide(BigInteger.valueOf(a++));
        }
        System.out.println(result);
    }
}
