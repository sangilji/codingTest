package baekjoon;

import java.util.Scanner;

public class Main11050 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int a = 1;
        int b = 1;
        for (int i = n; i > n - k; i--) {
            a *= i;
        }
        for (int i = k; i > 1; i--) {
            b *= i;
        }
        System.out.println(a / b);
    }
}
