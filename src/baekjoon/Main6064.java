package baekjoon;

import java.util.Scanner;

public class Main6064 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int s = 0; s < T; s++) {
            boolean check = false;
            int m = sc.nextInt();
            int n = sc.nextInt();
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            for (int i = x; i < (n * m); i += m) {
                if (i % n == y) {
                    System.out.println(i + 1);
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println(-1);

            }
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
