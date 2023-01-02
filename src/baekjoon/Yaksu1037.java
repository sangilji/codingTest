package baekjoon;

import java.util.Scanner;

public class Yaksu1037 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a;
        int max = 0;
        int min = 1000000;
        for (int i = 0; i < n; i++) {
            a = s.nextInt();
            if (max < a) {
                max = a;
            }
            if (min > a) {
                min = a;
            }
        }
        System.out.println(max * min);
    }
}
