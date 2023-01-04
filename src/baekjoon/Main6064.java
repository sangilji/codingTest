package baekjoon;

import java.util.Scanner;

public class Main6064 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int m = s.nextInt();
            int n = s.nextInt();
            int x = s.nextInt();
            int y = s.nextInt();
            System.out.println(check(m, n, x, y));

        }
    }

    private static int check(int m, int n, int x, int y) {
        int a;
        int b;
        int count;
        if (m < n) {
            a = b = count = x;
            while (true) {

                if (b == y) {
                    return count;
                }
                if (b + m > n) {
                    b = (b + m) % n;
                } else {
                    b += m;
                }
                count += m;
                if (a == b) {
                    break;
                }
            }
        } else if (m > n) {
            a = b = count = y;
            while (true) {
                if (a == x) {
                    return count;
                }
                if (a + n > m) {
                    a = (a + n) % m;
                } else {
                    a += n;
                }
                count += n;
                if (a == b) {
                    break;
                }
            }
        } else {
            if (x != y) {
                return -1;
            } else {
                return x;
            }
        }
        return -1;
    }
}
